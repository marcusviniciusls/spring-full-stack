package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.domain.enums.StatePayment;

import java.util.Objects;

public class PaymentCredit extends Payment {
    
    private Integer installments;

    public PaymentCredit(StatePayment statePayment, Order order, Integer installments) {
        super(statePayment, order);
        this.installments = installments;
    }
    
    public PaymentCredit(StatePayment statePayment, Order order){
        super(statePayment, order);
    }

    public Integer getInstallments() {
        return installments;
    }
}
