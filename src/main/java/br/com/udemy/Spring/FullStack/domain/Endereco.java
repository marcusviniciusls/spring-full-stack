package br.com.udemy.Spring.FullStack.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "enderecos")
public class Endereco extends SuperEntidade{

    private String logadouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL)
    private List<Pedido> listaPedidos = new ArrayList<>();

    public Endereco(String logadouro, String numero, String bairro, String cep, Cidade cidade) {
        this.logadouro = logadouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }

    public Endereco(String logadouro, String numero, String complemento, String bairro, String cep, Cidade cidade) {
        this.logadouro = logadouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }
    
    public Endereco (){}

    public String getLogadouro() {
        return logadouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }
    
    public void addListaPedidos(Pedido pedido){
        this.listaPedidos.add(pedido);
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "logadouro='" + logadouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade=" + cidade +
                ", cliente=" + cliente +
                ", listaPedidos=" + listaPedidos +
                '}';
    }
}
