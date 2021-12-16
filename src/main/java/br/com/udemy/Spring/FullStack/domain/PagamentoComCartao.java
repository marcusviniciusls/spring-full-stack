package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.domain.enums.EstadoPagamento;

import java.util.Objects;

public class PagamentoComCartao extends Pagamento{
    
    private Integer numeroParcelas;

    public PagamentoComCartao(EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroParcelas) {
        super(estadoPagamento, pedido);
        this.numeroParcelas = numeroParcelas;
    }
    
    public PagamentoComCartao(EstadoPagamento estadoPagamento, Pedido pedido){
        super(estadoPagamento, pedido);
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    @Override
    public String toString() {
        return "PagamentoComCartao{" +
                "numeroParcelas=" + numeroParcelas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagamentoComCartao that = (PagamentoComCartao) o;
        return Objects.equals(numeroParcelas, that.numeroParcelas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroParcelas);
    }
}
