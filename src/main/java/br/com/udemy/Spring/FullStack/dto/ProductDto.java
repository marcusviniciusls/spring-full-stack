package br.com.udemy.Spring.FullStack.dto;

import java.math.BigDecimal;

public class ProductDto {

    private String name;
    private BigDecimal price;

    public ProductDto(){}

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
