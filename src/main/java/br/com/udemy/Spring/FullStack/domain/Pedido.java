package br.com.udemy.Spring.FullStack.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * Classe de entidade para a tabela de Pedidos
 */
@Table
@Entity
public class Pedido extends SuperEntity {

    // Atributos
    @DateTimeFormat(pattern="dd-MMM-YYYY")
    private LocalDateTime dataCriacao = LocalDateTime.now();
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> listOrderItem = new ArrayList<>();

    private static Integer number = 1;
    
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "order")
    private List<Payment> payment = new ArrayList<>();

    private BigDecimal valueTotal = getValorTotal();

    // Construtores
    public Pedido(){
        this.number++;
    }

    public Pedido(Address address) {
        this.address = address;
        this.number++;
    }

    // Métodos gets e sets

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
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

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }

    public void addListPayment(Payment payment){
        this.payment.add(payment);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BigDecimal getValorTotal(){
        BigDecimal valueTotal = BigDecimal.ZERO;
        for (OrderItem orderItem : this.getListOrderItem()){
            valueTotal = valueTotal.add(orderItem.getTotalPrice());
        }
        return valueTotal;
    }

    public BigDecimal getValueTotal() {
        return valueTotal;
    }

    public void calculeValueTotal(){
        BigDecimal valueTotal = this.getValorTotal();
        this.setValueTotal(valueTotal);
    }

    public void setValueTotal(BigDecimal valueTotal) {
        this.valueTotal = valueTotal;
    }

    public static Integer getNumber() {
        return number;
    }

    public static void setNumber(Integer number) {
        Pedido.number = number;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        stringBuilder.append("Data: " + this.getDataCriacao());
        stringBuilder.append(" Endereço: " + this.getAddress().getAddress());
        stringBuilder.append(" Número: " + this.getAddress().getNumber());
        stringBuilder.append(" Complemento: " + this.getAddress().getComplement());
        stringBuilder.append(" Bairro: " + this.getAddress().getDistrict());
        stringBuilder.append(" Cidade: " + this.getAddress().getCity().getName());
        stringBuilder.append(" CEP: " + this.getAddress().getCep());
        stringBuilder.append(" Cidade: " + this.getAddress().getCity().getState().getName());
        stringBuilder.append(" Nome do Cliente: " + this.getClient().getNome());
        stringBuilder.append(" E-mail: " + this.getClient().getEmail());
        stringBuilder.append(" Telefone: " + this.getClient().getListTelephone().toString());
        stringBuilder.append(" Valor Total: " + numberFormat.format(this.getValorTotal()));
        stringBuilder.append(" Itens: ");
        stringBuilder.append(this.listOrderItem.toString());

        return stringBuilder.toString();
    }
}
