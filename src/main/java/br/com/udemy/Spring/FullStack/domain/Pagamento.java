package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.domain.enums.EstadoPagamento;

import javax.persistence.*;

@Table
@Entity(name = "pagamentos")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento extends SuperEntidade{

    @Enumerated(EnumType.ORDINAL)
    private EstadoPagamento estadoPagamento;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;

    public Pagamento(EstadoPagamento estadoPagamento, Pedido pedido) {
        this.estadoPagamento = estadoPagamento;
        this.pedido = pedido;
    }

    public EstadoPagamento getEstadoPagamento() {
        return estadoPagamento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "estadoPagamento=" + estadoPagamento +
                ", pedido=" + pedido +
                '}';
    }
}
