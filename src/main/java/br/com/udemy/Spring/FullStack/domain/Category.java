package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe de Entidade para a tabela categoria
 */
@Table
@Entity(name = "categories")
public class Category extends SuperEntity {

    // Atributos
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Product> listProduct = new ArrayList<>();

    // Construtores
    public Category(String name) {
        this.name = name;
    }
    
    public Category(){}

    // Métodos Gets e Sets
    public String getName() {
        return name;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }
    
    public void addListaProduto(Product product){
        this.listProduct.add(product);
    }

    public void setName(String name) {
        this.name = name;
    }
}
