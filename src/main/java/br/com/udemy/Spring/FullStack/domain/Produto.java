package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "produtos")
public class Produto extends SuperEntidade{

    private String nome;
    private BigDecimal preco;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ItemPedido> listaItemPedido = new ArrayList<>();

    public Produto(String nome, BigDecimal preco, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Produto(String nome, Categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = new BigDecimal("0.0");
    }
    
    public Produto(){}

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public List<ItemPedido> getListaItemPedido() {
        return listaItemPedido;
    }
    
    public void addItemPedido(ItemPedido itemPedido){
        this.listaItemPedido.add(itemPedido);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", categoria=" + categoria +
                ", listaItemPedido=" + listaItemPedido +
                '}';
    }
}
