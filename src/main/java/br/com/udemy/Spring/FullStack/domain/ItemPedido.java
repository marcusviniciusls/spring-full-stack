package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table
@Entity(name = "itens_pedidos")
public class ItemPedido extends SuperEntidade {

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

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "desconto=" + desconto +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                ", precoTotal=" + precoTotal +
                ", produto=" + produto +
                ", pedido=" + pedido +
                '}';
    }
}
