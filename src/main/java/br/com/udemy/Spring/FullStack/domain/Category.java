package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table
@Entity(name = "categories")
public class Category extends SuperEntity {
    
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Product> listProduct = new ArrayList<>();
    
    public Category(String name) {
        this.name = name;
    }
    
    public Category(){}

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
