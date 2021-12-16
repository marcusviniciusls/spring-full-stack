package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.domain.enums.EstadoPagamento;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Objects;

public class PagamentoComBoleto extends Pagamento{
    
    @Temporal(TemporalType.DATE)
    private LocalDate dataVencimento;
    
    @Temporal(TemporalType.DATE)
    private LocalDate dataPagamento;

    public PagamentoComBoleto(EstadoPagamento estadoPagamento, Pedido pedido, LocalDate dataVencimento, LocalDate dataPagamento) {
        super(estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public PagamentoComBoleto(EstadoPagamento estadoPagamento, Pedido pedido, LocalDate dataVencimento) {
        super(estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    @Override
    public String toString() {
        return "PagamentoComBoleto{" +
                "dataVencimento=" + dataVencimento +
                ", dataPagamento=" + dataPagamento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagamentoComBoleto that = (PagamentoComBoleto) o;
        return Objects.equals(dataVencimento, that.dataVencimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataVencimento);
    }
}
