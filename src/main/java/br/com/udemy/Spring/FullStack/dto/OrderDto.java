package br.com.udemy.Spring.FullStack.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class OrderDto {

    private LocalDate date;
    @JsonIgnore
    private AddressDto addressDto;

    public OrderDto(LocalDate date, AddressDto addressDto) {
        this.date = date;
        this.addressDto = addressDto;
    }

    public OrderDto(){}

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
}
