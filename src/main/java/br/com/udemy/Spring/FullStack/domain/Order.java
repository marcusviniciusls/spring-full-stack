package br.com.udemy.Spring.FullStack.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de entidade para a tabela de Pedidos
 */
@Table
@Entity(name = "orders")
public class Order extends SuperEntity {

    // Atributos
    private LocalDate date = LocalDate.now();
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> listOrderItem = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Construtores
    public Order(){}

    public Order(Address address) {
        this.address = address;
    }

    // Métodos gets e sets
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
