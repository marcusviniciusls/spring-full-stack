package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.domain.enums.StatePayment;

import javax.persistence.*;

/**
 * Classe de entidades para a tabela de pagamentos
 */
@Table
@Entity(name = "payments")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment extends SuperEntity {

    // Atributos
    @Enumerated(EnumType.ORDINAL)
    private StatePayment statePayment;

    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private Order order;

    // Construtores
    public Payment(StatePayment statePayment, Order order) {
        this.statePayment = statePayment;
        this.order = order;
    }

    // Métodos gets e Sets
    public StatePayment getStatePayment() {
        return statePayment;
    }

    public Order getOrder() {
        return order;
    }
}
