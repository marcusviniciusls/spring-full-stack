package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Address;
import br.com.udemy.Spring.FullStack.domain.Payment;
import br.com.udemy.Spring.FullStack.domain.Pedido;
import br.com.udemy.Spring.FullStack.domain.OrderItem;
import br.com.udemy.Spring.FullStack.dto.AddressDto;
import br.com.udemy.Spring.FullStack.dto.ClientDto;
import br.com.udemy.Spring.FullStack.dto.OrderDto;
import br.com.udemy.Spring.FullStack.dto.OrderItemDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que contém regras de negócios para a entidade Order
 */
@Service
public class OrderBusinessRule {

    /**
     * Método que tem por objeto converter um objeto do tipo Order em OrderDto
     * @param order - Recebe um objeto do tipo order
     * @return - Retorna um objeto OrderDto
     */
    public static OrderDto convertOrderInOrderDto(Pedido order){
        OrderDto orderDto = new OrderDto();

        orderDto.setDate(order.getData());
        AddressDto addressDto = convertAddressDto(order.getAddress());
        orderDto.setEndereco(addressDto);
        ClientDto clientDto = ClientBusinessRule.convertClientDto(order.getClient());
        orderDto.setClientDto(clientDto);
        List<OrderItemDto> listOrderItemDto = new ArrayList<>();
        for (OrderItem orderItem : order.getListOrderItem()){
            listOrderItemDto.add(OrderItemBusinessRule.convertOrderItemInOrderItemDto(orderItem));
        }
        orderDto.setOrderItemDto(listOrderItemDto);
        orderDto.setListPayment(order.getPayment());

        return orderDto;
    }

    /**
     * Converte um objeto do tipo Address em AddressDto
     * @param address - Recebe um objeto do tipo Address
     * @return - Retorna um objeto do tipo AddressDto
     */
    private static AddressDto convertAddressDto(Address address){
        AddressDto addressDto = new AddressDto();

        addressDto.setDistrict(address.getDistrict());
        addressDto.setCep(address.getCep());
        addressDto.setComplement(address.getComplement());
        addressDto.setLogadouro(address.getAddress());
        addressDto.setNumber(address.getNumber());

        return addressDto;
    }

    public static BigDecimal getTotalOrder(List<OrderItemDto> listOrderItemDto){
        BigDecimal valueTotal = BigDecimal.ZERO;
        for(OrderItemDto orderItemDto : listOrderItemDto){
            valueTotal = valueTotal.add(orderItemDto.getSubTotal());
        }
        return valueTotal;
    }
}
