package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.domain.enums.StatePayment;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Objects;

public class PaymentTicket extends Payment {
    
    @Temporal(TemporalType.DATE)
    private LocalDate dueDate;
    
    @Temporal(TemporalType.DATE)
    private LocalDate paymentDate;

    public PaymentTicket(StatePayment statePayment, Order order, LocalDate dueDate, LocalDate paymentDate) {
        super(statePayment, order);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public PaymentTicket(StatePayment statePayment, Order order, LocalDate dueDate) {
        super(statePayment, order);
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }
}
