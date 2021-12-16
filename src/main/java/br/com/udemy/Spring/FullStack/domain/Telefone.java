package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity(name = "telefones")
public class Telefone extends SuperEntidade{

    private String ddd;
    private String telefone;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Telefone(String ddd, String telefone) {
        this.ddd = ddd;
        this.telefone = telefone;
    }
    
    public Telefone(){}

    public String getDdd() {
        return ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "ddd='" + ddd + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
