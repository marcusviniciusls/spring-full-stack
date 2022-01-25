package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity(name = "citys")
public class City extends SuperEntity {
    
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    public City(String name, State state) {
        this.name = name;
        this.state = state;
    }
    
    public City(){}

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }
}
