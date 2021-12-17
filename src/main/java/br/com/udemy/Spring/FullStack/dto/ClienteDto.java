package br.com.udemy.Spring.FullStack.dto;

import br.com.udemy.Spring.FullStack.domain.enums.Natureza;

import java.util.ArrayList;
import java.util.List;

public class ClienteDto {
    
    private String nome;
    private String email;
    private Natureza natureza;
    private String cpf;
    private String cnpj;
    private List<TelefoneDto> listTelefones = new ArrayList<>();
    private List<EnderecoDto> listEnderecos = new ArrayList<>();
    
    public ClienteDto(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Natureza getNatureza() {
        return natureza;
    }

    public void setNatureza(Natureza natureza) {
        this.natureza = natureza;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<TelefoneDto> getListTelefones() {
        return listTelefones;
    }

    public void setListTelefones(List<TelefoneDto> listTelefones) {
        this.listTelefones = listTelefones;
    }

    public List<EnderecoDto> getListEnderecos() {
        return listEnderecos;
    }

    public void setListEnderecos(List<EnderecoDto> listEnderecos) {
        this.listEnderecos = listEnderecos;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
