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
@Entity
public class State extends SuperEntity {

    // Atributos
    private Integer code;
    private String name;
    private String uf;
    
    @OneToMany(mappedBy = "state")
    private List<City> listCity = new ArrayList<>();

    // Construtores
    public State(Integer code, String name, String uf) {
        this.code = code;
        this.name = name;
        this.uf = uf;
    }

    public State(){}

    // Métodos Gets e Sets
    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    public String getUf() {
        return uf;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<City> getListCity() {
        return listCity;
    }
    
    public void addCidade(City city){
        this.listCity.add(city);
    }
}
