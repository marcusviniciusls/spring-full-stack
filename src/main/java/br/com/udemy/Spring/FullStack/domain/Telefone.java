package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    public Cliente getCliente() {
       return cliente;
    }

   public void setCliente(Cliente cliente) {
       this.cliente = cliente;
   }

}
