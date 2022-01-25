package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Address;
import br.com.udemy.Spring.FullStack.domain.Order;
import br.com.udemy.Spring.FullStack.dto.AddressDto;
import br.com.udemy.Spring.FullStack.dto.OrderDto;

public class OrderBusinessRule {

    public static OrderDto convertPedidoDao(Order order){
        OrderDto orderDto = new OrderDto();

        orderDto.setDate(order.getDate());
        AddressDto addressDto = convertEnderecoDto(order.getAddress());
        orderDto.setEndereco(addressDto);

        return orderDto;
    }

    private static AddressDto convertEnderecoDto(Address address){
        AddressDto addressDto = new AddressDto();

        addressDto.setDistrict(address.getDistrict());
        addressDto.setCep(address.getCep());
        addressDto.setComplement(address.getComplement());
        addressDto.setLogadouro(address.getAddress());
        addressDto.setNumber(address.getNumber());

        return addressDto;
    }
}
