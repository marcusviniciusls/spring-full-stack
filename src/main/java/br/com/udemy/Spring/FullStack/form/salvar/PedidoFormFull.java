package br.com.udemy.Spring.FullStack.form.salvar;

import br.com.udemy.Spring.FullStack.domain.Payment;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PedidoFormFull {

    // Atributos
    private String cpfOrCnpj;
    private Integer numberOfInstallments;
    private String payment;
    private List<OrderItemForm> listItems = new ArrayList<>();

    // Construtores
    public PedidoFormFull(String cpfOrCnpj, Integer numberOfInstallments, String payment) {
        this.cpfOrCnpj = cpfOrCnpj;
        this.numberOfInstallments = numberOfInstallments;
        this.payment = payment;
    }

    public PedidoFormFull(){}

    // Métodos Gets e Sets
    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public String getPayment() {
        return payment;
    }

    public List<OrderItemForm> getListItems() {
        return listItems;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setListItems(List<OrderItemForm> listItems) {
        this.listItems = listItems;
    }

    public void addListItems(OrderItemForm orderItemForm){
        this.listItems.add(orderItemForm);
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }
}
