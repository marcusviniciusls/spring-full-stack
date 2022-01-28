package br.com.udemy.Spring.FullStack.form.salvar;

import org.hibernate.annotations.Type;

import java.util.UUID;

public class OrderItemForm {

    // Atributos
    @Type(type="org.hibernate.type.UUIDCharType")
    private Integer quantity;
    private UUID idProduct;

    // Construtores
    public OrderItemForm(Integer quantity, UUID idProduct) {
        this.quantity = quantity;
        this.idProduct = idProduct;
    }

    public OrderItemForm(){}

    // Métodos Gets e Sets
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UUID getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }
}
