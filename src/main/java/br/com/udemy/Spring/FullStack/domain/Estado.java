package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "estados")
public class Estado extends SuperEntidade{

    private String nome;
    
    @OneToMany(mappedBy = "estado")
    private List<Cidade> listaCidades = new ArrayList<>(); 

    public Estado(String nome) {
        this.nome = nome;
    }
    
    public Estado(){}

    public String getNome() {
        return nome;
    }
    
    public List<Cidade> getListaCidades() {
        return listaCidades;
    }
    
    public void addCidade(Cidade cidade){
        this.listaCidades.add(cidade);
    }

    @Override
    public String toString() {
        return "Estado{" +
                "nome='" + nome + '\'' +
                ", listaCidades=" + listaCidades +
                '}';
    }
}
