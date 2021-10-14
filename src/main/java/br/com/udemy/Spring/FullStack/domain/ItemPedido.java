package br.com.udemy.Spring.FullStack.domain;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table
@Entity(name = "itens_pedidos")
public class ItemPedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal desconto;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal precoTotal;
    
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public ItemPedido(BigDecimal desconto, Integer quantidade, BigDecimal precoUnitario) {
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoTotal = new BigDecimal(String.valueOf(precoUnitario.multiply(BigDecimal.valueOf(quantidade))));
    }

    public ItemPedido(Integer quantidade, BigDecimal precoUnitario) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoTotal = new BigDecimal(String.valueOf(precoUnitario.multiply(BigDecimal.valueOf(quantidade))));
    }
    
    public ItemPedido(){}

    public Integer getId() {
        return id;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "id=" + id +
                ", desconto=" + desconto +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                ", precoTotal=" + precoTotal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
