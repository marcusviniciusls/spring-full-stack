package br.com.udemy.Spring.FullStack.dto;

import java.math.BigDecimal;

/**
 * Data Transfer Object para OrderItemDto
 */
public class OrderItemDto {

    // Atributos
    private BigDecimal discount;
    private Integer quantity;
    private BigDecimal unityPrice;
    private BigDecimal totalPrice;
    private ProductDto productDto;

    //Construtores
    public OrderItemDto(BigDecimal discount, Integer quantity, BigDecimal unityPrice, BigDecimal totalPrice, ProductDto productDto) {
        this.discount = discount;
        this.quantity = quantity;
        this.unityPrice = unityPrice;
        this.totalPrice = totalPrice;
        this.productDto = productDto;
    }
    public OrderItemDto(){}

    // Métodos Gets e Sets
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnityPrice() {
        return unityPrice;
    }

    public void setUnityPrice(BigDecimal unityPrice) {
        this.unityPrice = unityPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }
}
