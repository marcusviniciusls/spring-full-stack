package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de entidade da tabela de Estados
 */
@Table
@Entity(name = "states")
public class State extends SuperEntity {

    // Atributos
    private String name;
    
    @OneToMany(mappedBy = "state")
    private List<City> listCity = new ArrayList<>();

    // Construtores
    public State(String name) {
        this.name = name;
    }
    
    public State(){}

    // Métodos Gets e Sets
    public String getName() {
        return name;
    }
    
    public List<City> getListCity() {
        return listCity;
    }
    
    public void addCidade(City city){
        this.listCity.add(city);
    }
}
