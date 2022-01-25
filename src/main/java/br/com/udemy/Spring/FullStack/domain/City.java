package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe de Entidade para a tabela de Cidade
 */
@Table
@Entity(name = "citys")
public class City extends SuperEntity {

    // Atributos
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    // Construtores
    public City(String name, State state) {
        this.name = name;
        this.state = state;
    }
    
    public City(){}

    // Métodos Get e Set
    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }
}
