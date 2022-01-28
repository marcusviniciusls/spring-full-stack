package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.domain.enums.StatePayment;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;

/**
 * Classe de entidades para a tabela de pagamentos
 */
@Table
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Payment extends SuperEntity {

    // Atributos
    @Enumerated(EnumType.ORDINAL)
    private StatePayment statePayment;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Pedido order;

    // Construtores
    public Payment(StatePayment statePayment, Pedido order) {
        this.statePayment = statePayment;
        this.order = order;
    }

    public Payment(){}

    // Métodos gets e Sets
    public StatePayment getStatePayment() {
        return statePayment;
    }

    public Pedido getOrder() {
        return order;
    }

    public void setStatePayment(StatePayment statePayment) {
        this.statePayment = statePayment;
    }

    public void setOrder(Pedido order) {
        this.order = order;
    }
}
