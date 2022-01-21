package br.com.udemy.Spring.FullStack.dto;

import java.math.BigDecimal;

public class ProdutoDto {

    private String nome;
    private BigDecimal preco;

    public ProdutoDto (){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
