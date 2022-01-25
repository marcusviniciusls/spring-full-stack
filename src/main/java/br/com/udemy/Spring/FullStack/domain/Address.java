package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "addresss")
public class Address extends SuperEntity {

    private String address;
    private String number;
    private String complement;
    private String district;
    private String cep;
    
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;
    
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Order> listOrder = new ArrayList<>();

    public Address(String address, String number, String district, String cep, City city) {
        this.address = address;
        this.number = number;
        this.district = district;
        this.cep = cep;
        this.city = city;
    }

    public Address(String address, String number, String complement, String district, String cep, City city) {
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.cep = cep;
        this.city = city;
    }
    
    public Address(){}

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getDistrict() {
        return district;
    }

    public String getCep() {
        return cep;
    }

    public City getCity() {
        return city;
    }

    public Client getClient() {
        return client;
    }

    public List<Order> getListOrder() {
        return listOrder;
    }
    
    public void addListaPedidos(Order pedido){
        this.listOrder.add(pedido);
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
