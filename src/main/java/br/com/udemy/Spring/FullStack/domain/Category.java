package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de Entidade para a tabela categoria
 */
@Table
@Entity
public class Category extends SuperEntity {

    // Atributos
    private String nome;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Product> listProduct = new ArrayList<>();

    // Construtores
    public Category(String name) {
        this.nome = name;
    }
    
    public Category(){}

    // Métodos Gets e Sets
    public String getNome() {
        return nome;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }
    
    public void addListaProduto(Product product){
        this.listProduct.add(product);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
