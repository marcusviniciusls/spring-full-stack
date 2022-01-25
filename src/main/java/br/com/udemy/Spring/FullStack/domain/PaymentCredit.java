package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.domain.enums.StatePayment;

import java.util.Objects;

/**
 * Classe filha de Payment
 */
public class PaymentCredit extends Payment {

    // Atributos
    private Integer installments;

    // Construtores
    public PaymentCredit(StatePayment statePayment, Order order, Integer installments) {
        super(statePayment, order);
        this.installments = installments;
    }
    
    public PaymentCredit(StatePayment statePayment, Order order){
        super(statePayment, order);
    }

    // Métodos gets e sets
    public Integer getInstallments() {
        return installments;
    }
}
