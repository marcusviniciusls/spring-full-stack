package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "products")
public class Product extends SuperEntity {

    private String name;
    private BigDecimal price;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderItem> listOrderItem = new ArrayList<>();

    public Product(String name, BigDecimal price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
        this.price = new BigDecimal("0.0");
    }
    
    public Product(){}

    public String getName() {
        return name;
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
