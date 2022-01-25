package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.domain.enums.Nature;
import br.com.udemy.Spring.FullStack.exception.InvalidNatureCustomer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "clients")
public class Client extends SuperEntity {

    private String name;
    private String email;
    
    @Enumerated(EnumType.ORDINAL)
    private Nature nature;
    
    private String cpf;
    private String cnpj;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Telephone> listTelephone = new ArrayList<>();
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Address> listAddress = new ArrayList<>();

    public Client(String name, String email, Integer value, String cpgOrCnpj) {
        this.name = name;
        this.email = email;
        this.nature = Nature.toEnum(value);
        verificarCpfOuCnpj(value,cpgOrCnpj);
        setNature(value);
    }
    
    public Client(){}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Nature getNature() {
        return nature;
    }

    public void addListaEndereco(Address address){
        this.listAddress.add(address);
    }
    
    public void addListaTelefone(Telephone telephone){
        this.listTelephone.add(telephone);
    }
    
    public String getCpf() {
        return cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<Telephone> getListTelephone() {
        return this.listTelephone;
    }

    public List<Address> getListAddress() {
        return this.listAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void verificarCpfOuCnpj(Integer value, String cpfOrCnpj){
        if (value == 0){
            this.cpf = cpfOrCnpj;
        } else if (value ==1) {
            this.cnpj = cpfOrCnpj;
        } else {
            throw new InvalidNatureCustomer("CPF OR CNPJ NOT VALID");
        }
    }
    
    public void setNature(Integer value){
        if (value == 0){
            this.nature = Nature.PESSOA_FISICA;
        } if (value == 1){
            this.nature = Nature.PESSOA_JURIDICA;
        }
    }
    public void verificarCpfOuCnpjEntidadeCliente(String cpfOrCnpj){
        if (Nature.PESSOA_FISICA.getValue() == 0){
            this.cpf = cpfOrCnpj;
        } else if (Nature.PESSOA_JURIDICA.getValue() == 1) {
            this.cnpj = cpfOrCnpj;
        } else {
            throw new InvalidNatureCustomer("CPF OR CNPJ NOT VALID");
        }
    }
}