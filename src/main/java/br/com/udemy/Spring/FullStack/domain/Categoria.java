package br.com.udemy.Spring.FullStack.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table
@Entity(name = "categories")
public class Categoria extends SuperEntidade{
    
    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.PERSIST)
    private List<Produto> listaProdutos = new ArrayList<>();
    
    public Categoria(String nome) {
        this.nome = nome;
    }
    
    public Categoria(){}

    public String getNome() {
        return nome;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }
    
    public void addListaProduto(Produto produto){
        this.listaProdutos.add(produto);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nome, categoria.nome) && Objects.equals(listaProdutos, categoria.listaProdutos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nome='" + nome + '\'' +
                ", listaProdutos=" + listaProdutos +
                '}';
    }
}
