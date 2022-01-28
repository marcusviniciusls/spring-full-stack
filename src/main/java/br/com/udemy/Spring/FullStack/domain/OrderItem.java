package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Classe de entidades para a tabela associativa entre Pedidos e Produtos (Pedidos_Itens)
 */
@Table
@Entity(name = "order_items")
public class OrderItem extends SuperEntity {

    // Atributos
    private BigDecimal discount;
    private Integer quantity;
    private BigDecimal unityPrice;
    private BigDecimal totalPrice;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Pedido order;

    // Construtores
    public OrderItem(BigDecimal discount, Integer quantity, BigDecimal unityPrice) {
        this.discount = discount;
        this.quantity = quantity;
        this.unityPrice = unityPrice;
        this.totalPrice = new BigDecimal(String.valueOf(unityPrice.multiply(BigDecimal.valueOf(quantity))));
    }

    public OrderItem(Integer quantity, BigDecimal unityPrice) {
        this.quantity = quantity;
        this.unityPrice = unityPrice;
        this.totalPrice = new BigDecimal(String.valueOf(unityPrice.multiply(BigDecimal.valueOf(quantity))));
    }
    
    public OrderItem(){}

    // Métodos Gets e Sets
    public BigDecimal getDiscount() {
        return discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getUnityPrice() {
        return unityPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrder(Pedido order) {
        this.order = order;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setUnityPrice(BigDecimal unityPrice) {
        this.unityPrice = unityPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
