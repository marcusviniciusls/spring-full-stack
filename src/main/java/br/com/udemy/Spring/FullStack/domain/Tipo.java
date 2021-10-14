package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table
@Entity(name = "tipos")
public class Tipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    
    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL)
    private List<Cliente> listaCliente = new ArrayList<>();

    public Tipo(String nome) {
        this.nome = nome;
    }

    public Tipo(String nome, Cliente cliente) {
        this.nome = nome;
        this.addListaCLiente(cliente);
    }

    public Tipo(){}

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Cliente> getCliente() {
        return listaCliente;
    }
    
    public void addListaCLiente(Cliente cliente){
        this.listaCliente.add(cliente);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipo tipo = (Tipo) o;
        return Objects.equals(id, tipo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
