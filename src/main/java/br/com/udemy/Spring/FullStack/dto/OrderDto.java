package br.com.udemy.Spring.FullStack.dto;

import br.com.udemy.Spring.FullStack.domain.Client;
import br.com.udemy.Spring.FullStack.factory.OrderBusinessRule;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Data Transfer Object (Dto) para a entidade Order
 */
public class OrderDto {

    // Atributos
    private LocalDate date;
    private AddressDto addressDto;
    private ClientDto clientDto;
    private List<OrderItemDto> orderItemDto = new ArrayList<>();

    // Construtores
    public OrderDto(LocalDate date, AddressDto addressDto) {
        this.date = date;
        this.addressDto = addressDto;
    }

    public OrderDto(){}

    // Métodos Gets e Sets
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AddressDto getEndereco() {
        return addressDto;
    }

    public void setEndereco(AddressDto enderecoDto) {
        this.addressDto = enderecoDto;
    }

    public void setOrderItemDto(List<OrderItemDto> orderItemDto) {
        this.orderItemDto = orderItemDto;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public ClientDto getClientDto() {
        return clientDto;
    }

    public void setClientDto(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    public List<OrderItemDto> getOrderItemDto() {
        return orderItemDto;
    }

    public BigDecimal getTotal(){
        return OrderBusinessRule.getTotalOrder(this.orderItemDto);
    }
}
