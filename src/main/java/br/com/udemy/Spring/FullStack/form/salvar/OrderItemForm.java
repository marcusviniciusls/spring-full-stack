package br.com.udemy.Spring.FullStack.form.salvar;

import org.hibernate.annotations.Type;

import java.util.UUID;

public class OrderItemForm {

    // Atributos
    private Integer quantity;
    private String codyProduct;

    // Construtores
    public OrderItemForm(Integer quantity, String codyProduct) {
        this.quantity = quantity;
        this.codyProduct = codyProduct;
    }

    public OrderItemForm(){}

    // Métodos Gets e Sets
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCodyProduct() {
        return codyProduct;
    }

    public void setCodyProduct(String codyProduct) {
        this.codyProduct = codyProduct;
    }
}
