package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Address;
import br.com.udemy.Spring.FullStack.domain.Order;
import br.com.udemy.Spring.FullStack.dto.AddressDto;
import br.com.udemy.Spring.FullStack.dto.OrderDto;
/**
 * Classe que contém regras de negócios para a entidade Order
 */
public class OrderBusinessRule {

    /**
     * Método que tem por objeto converter um objeto do tipo Order em OrderDto
     * @param order - Recebe um objeto do tipo order
     * @return - Retorna um objeto OrderDto
     */
    public static OrderDto convertOrderInOrderDto(Order order){
        OrderDto orderDto = new OrderDto();

        orderDto.setDate(order.getDate());
        AddressDto addressDto = convertAddressDto(order.getAddress());
        orderDto.setEndereco(addressDto);

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
}
