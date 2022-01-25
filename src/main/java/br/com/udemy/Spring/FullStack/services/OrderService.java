package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Order;
import br.com.udemy.Spring.FullStack.dto.OrderDto;
import br.com.udemy.Spring.FullStack.exception.ResourceNotFoundException;
import br.com.udemy.Spring.FullStack.factory.OrderBusinessRule;
import br.com.udemy.Spring.FullStack.repositorys.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderDto findById(UUID id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()){
            throw new ResourceNotFoundException("Order Not Found");
        }
        Order order = optionalOrder.get();
        return OrderBusinessRule.convertPedidoDao(order);
    }
}
