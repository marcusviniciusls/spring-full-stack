package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.domain.enums.StatePayment;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe filha de Payment
 */
@Table
@Entity
@JsonTypeName("pagamentoComCartao")
public class PaymentCredit extends Payment {

    // Atributos
    private Integer installments;

    // Construtores
    public PaymentCredit(StatePayment statePayment, Pedido order, Integer installments) {
        super(statePayment, order);
        this.installments = installments;
    }
    
    public PaymentCredit(StatePayment statePayment, Pedido order){
        super(statePayment, order);
    }

    public PaymentCredit() {}

    // Métodos gets e sets
    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }
}
