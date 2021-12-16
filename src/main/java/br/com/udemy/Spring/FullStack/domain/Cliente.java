package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.domain.enums.Natureza;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table
@Entity(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    
    @Enumerated(EnumType.ORDINAL)
    private Natureza natureza;
    
    private String cpf;
    private String cnpj;
    
    @OneToMany(mappedBy = "telefone", cascade = CascadeType.ALL)
    private List<Telefone> listaTelefones = new ArrayList<>();
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> listaEnderecos = new ArrayList<>();

    public Cliente(String nome, String email, Natureza natureza) {
        this.nome = nome;
        this.email = email;
        this.natureza = natureza;
    }

    public Cliente(String nome, String email, Natureza natureza, String cpf) {
        this.nome = nome;
        this.email = email;
        this.natureza = natureza;
        this.cpf = cpf;
    }
    
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Natureza getNatureza() {
        return natureza;
    }

    public void addListaEndereco(Endereco endereco){
        this.listaEnderecos.add(endereco);
    }
    
    public void addListaCliente(Telefone telefone){
        this.listaTelefones.add(telefone);    
    }
    
    public String getCpf() {
        return cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<Telefone> getListaTelefones() {
        return listaTelefones;
    }

    public List<Endereco> getListaEnderecos() {
        return listaEnderecos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", natureza=" + natureza +
                ", cpf='" + cpf + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
