package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table
@Entity(name = "estados")
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    
    @OneToMany(mappedBy = "estado")
    private List<Cidade> listaCidades = new ArrayList<>(); 

    public Estado(String nome) {
        this.nome = nome;
    }
    
    public Estado(){}

    public Integer getId() {
        return id;
    }

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
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id, estado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
