package br.com.udemy.Spring.FullStack.dto;

import java.math.BigDecimal;

/**
 * Classe responsável por levar informações do produto para o controller
 */
public class ProductFindSalesDto {

    // Atributos
    private String name;
    private BigDecimal price;

    // Construtores
    public ProductFindSalesDto(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
    public ProductFindSalesDto(){}

    // Métodos Gets e Sets
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
