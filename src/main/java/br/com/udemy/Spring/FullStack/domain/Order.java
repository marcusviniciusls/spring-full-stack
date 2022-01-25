package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "orders")
public class Order extends SuperEntity {

    private LocalDate date = LocalDate.now();
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> listOrderItem = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    
    public Order(){}

    public Order(Address address) {
        this.address = address;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<OrderItem> getListOrderItem() {
        return listOrderItem;
    }
    
    public void addListaItemPedidos(OrderItem orderItem){
        this.listOrderItem.add(orderItem);
    }

    public Address getAddress() {
        return address;
    }
}
