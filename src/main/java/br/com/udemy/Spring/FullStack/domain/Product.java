package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de entidade para a tabela de produtos
 */
@Table
@Entity
public class Product extends SuperEntity {

    // Atributos
    private String nome;
    private BigDecimal price;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @OneToMany(mappedBy = "product")
    private List<OrderItem> listOrderItem = new ArrayList<>();

    // Construtores
    public Product(String name, BigDecimal price, Category category) {
        this.nome = name;
        this.price = price;
        this.category = category;
    }

    public Product(String name, Category category) {
        this.nome = name;
        this.category = category;
        this.price = new BigDecimal("0.0");
    }
    
    public Product(){}

    // Métodos gets e sets
    public String getNome() {
        return nome;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public List<OrderItem> getListOrderItem() {
        return listOrderItem;
    }
    
    public void addItemPedido(OrderItem orderItem){
        this.listOrderItem.add(orderItem);
    }
}
