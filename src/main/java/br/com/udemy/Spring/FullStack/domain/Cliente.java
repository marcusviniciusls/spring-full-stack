package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.domain.enums.Natureza;
import br.com.udemy.Spring.FullStack.exception.InvalidNatureCustomer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "cliente")
public class Cliente extends SuperEntidade{

    private String nome;
    private String email;
    
    @Enumerated(EnumType.ORDINAL)
    private Natureza natureza;
    
    private String cpf;
    private String cnpj;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Telefone> listaTelefones = new ArrayList<>();
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> listaEnderecos = new ArrayList<>();

    public Cliente(String nome, String email, Integer value, String cpfOuCnpj) {
        this.nome = nome;
        this.email = email;
        this.natureza = Natureza.toEnum(value);
        verificarCpfOuCnpj(value,cpfOuCnpj);
        setNatureza(value);
    }
    
    public Cliente(){}

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


    private void verificarCpfOuCnpj(Integer value, String cpfOuCnpj){
        if (value == 0){
            this.cpf = cpfOuCnpj;
        } else if (value ==1) {
            this.cnpj = cpfOuCnpj;    
        } else {
            throw new InvalidNatureCustomer("CPF ou CNPJ invaĺido");
        }
    }
    
    private void setNatureza(Integer value){
        if (value == 0){
            this.natureza = Natureza.PESSOA_FISICA;
        } if (value == 1){
            this.natureza = Natureza.PESSOA_JURIDICA;
        }
    }
    
}
