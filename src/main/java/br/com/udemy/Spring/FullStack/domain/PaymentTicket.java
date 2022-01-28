package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.domain.enums.StatePayment;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
/**
 * Classe filha de Payment
 */
@Table
@Entity
@JsonTypeName("pagamentoComBoleto")
public class PaymentTicket extends Payment {

    // Atributos
    private LocalDate dueDate;
    private LocalDate paymentDate;

    // Construtores
    public PaymentTicket(StatePayment statePayment, Pedido order, LocalDate dueDate, LocalDate paymentDate) {
        super(statePayment, order);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }

    public PaymentTicket(){}

    public PaymentTicket(StatePayment statePayment, Pedido order, LocalDate dueDate) {
        super(statePayment, order);
        this.dueDate = dueDate;
    }

    // Métodos Gets e Sets
    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
