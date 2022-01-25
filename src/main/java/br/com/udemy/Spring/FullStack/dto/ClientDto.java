package br.com.udemy.Spring.FullStack.dto;

import br.com.udemy.Spring.FullStack.domain.enums.Nature;

import java.util.ArrayList;
import java.util.List;

public class ClientDto {
    
    private String name;
    private String email;
    private Nature nature;
    private String cpf;
    private String cnpj;
    private List<TelephoneDto> listTelephones = new ArrayList<>();
    private List<AddressDto> listAddress = new ArrayList<>();
    
    public ClientDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<TelephoneDto> getListTelephones() {
        return listTelephones;
    }

    public void setListTelephones(List<TelephoneDto> listTelephones) {
        this.listTelephones = listTelephones;
    }

    public List<AddressDto> getListAddress() {
        return listAddress;
    }

    public void setListAddress(List<AddressDto> listAddress) {
        this.listAddress = listAddress;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
