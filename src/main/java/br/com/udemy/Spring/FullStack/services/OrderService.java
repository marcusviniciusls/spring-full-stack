package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.*;
import br.com.udemy.Spring.FullStack.dto.CategoryDto;
import br.com.udemy.Spring.FullStack.dto.ClientDto;
import br.com.udemy.Spring.FullStack.dto.OrderDto;
import br.com.udemy.Spring.FullStack.exception.AuthorizationException;
import br.com.udemy.Spring.FullStack.exception.ResourceNotFoundException;
import br.com.udemy.Spring.FullStack.factory.*;
import br.com.udemy.Spring.FullStack.form.salvar.OrderItemForm;
import br.com.udemy.Spring.FullStack.form.salvar.PedidoFormFull;
import br.com.udemy.Spring.FullStack.repositorys.*;
import br.com.udemy.Spring.FullStack.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EmailService emailService;

    public OrderDto findById(UUID id){
        Optional<Pedido> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()){
            throw new ResourceNotFoundException("Order Not Found");
        }
        if (optionalOrder.get().isStatus() != true){
            throw new ResourceNotFoundException("Order Not Found");
        }
        Pedido order = optionalOrder.get();
        return OrderBusinessRule.convertOrderInOrderDto(order);
    }

    @Transactional
    public void saveOrder(PedidoFormFull pedidoFormFull){
        Client client = clientService.findByClientPerCpfOrCnpj(pedidoFormFull.getCpfOrCnpj());
        Address address = client.getListAddress().get(0);
        address.setClient(client);
        Pedido order = new Pedido();
        order.setClient(client);
        order.setAddress(address);
        List<OrderItem> listOrderItem = new ArrayList<>();
        for (OrderItemForm orderItemForm : pedidoFormFull.getListItems()){
            Optional<Product> optionalProduct = productRepository.findByProduct(orderItemForm.getCodyProduct());
            if (optionalProduct.isEmpty()){
                throw new ResourceNotFoundException("Product Not Found");
            }
            Product product = optionalProduct.get();
            OrderItem orderItem = OrderItemBusinessRule.convertPedidoFormFullInOrderItem(orderItemForm,product);
            orderItem.setOrder(order);
            order.addListaItemPedidos(orderItem);
            listOrderItem.add(orderItem);
        }
        order.calculeValueTotal();
        orderRepository.save(order);
        orderItemRepository.saveAll(order.getListOrderItem());
        String verifyPayment = pedidoFormFull.getPayment().toUpperCase();
        if (verifyPayment.equals("PAGAMENTOCOMBOLETO")){
            PaymentTicket payment = new PaymentTicket();
            payment.setDueDate(PaymentBusinessRule.definePaymentTicket(payment));
            payment.setOrder(order);
            order.addListPayment(payment);
            paymentRepository.save(payment);
        } if (verifyPayment.equals("PAGAMENTOCOMCARTAO")){
            PaymentCredit payment = new PaymentCredit();
            payment.setInstallments(pedidoFormFull.getNumberOfInstallments());
            payment.setOrder(order);
            order.addListPayment(payment);
            paymentRepository.save(payment);
        }
        emailService.sendOrderConfirmationHtmlEmail(order);
    }

    public Page<OrderDto> findByClient(Integer page, Integer linesPerPage, String orderBy, String direction){
        UserSS user = UserService.authenticated();
        if (user == null){
            throw new AuthorizationException("Access Denied");
        }
        Pageable pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        Optional<Client> optionalClient = clientRepository.findById(user.getId());
        if (optionalClient.isEmpty()){
            throw new ResourceNotFoundException("Client Not Found");
        }
        Client client = optionalClient.get();
        Page<Pedido> orderPage = orderRepository.findByClient(client,pageRequest);
        Page<OrderDto> orderDtoPage = orderPage.map(OrderBusinessRule::convertOrderInOrderDto);
        return orderDtoPage;
    }
}
