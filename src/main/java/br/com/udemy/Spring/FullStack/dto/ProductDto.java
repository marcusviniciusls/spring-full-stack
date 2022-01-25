package br.com.udemy.Spring.FullStack.dto;

import java.math.BigDecimal;

/**
 * Classe Data Transfer Object (Dto) para a entidade Product
 */
public class ProductDto {

    // Atributos
    private String name;
    private BigDecimal price;

    // Construtores
    public ProductDto(){}

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
