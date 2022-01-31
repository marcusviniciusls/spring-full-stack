package br.com.udemy.Spring.FullStack.domain;

import br.com.udemy.Spring.FullStack.domain.enums.Nature;
import br.com.udemy.Spring.FullStack.exception.InvalidNatureCustomer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de entidade da tabela cliente
 */
@Table
@Entity
public class Client extends SuperEntity {

    // Atributos
    private String nome;
    private String email;
    
    @Enumerated(EnumType.ORDINAL)
    private Nature nature;
    
    private String cpf;
    private String cnpj;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Telephone> listTelephone = new ArrayList<>();
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Address> listAddress = new ArrayList<>();

    // Construtores
    public Client(String name, String email, Integer value, String cpgOrCnpj) {
        this.nome = name;
        this.email = email;
        this.nature = Nature.toEnum(value);
        verificarCpfOuCnpj(value,cpgOrCnpj);
        setNature(value);
    }
    
    public Client(){}

    // Métodos Gets e Sets
    public String getNome() {
        return nome;
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
        this.nome = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setListTelephone(List<Telephone> listTelephone) {
        this.listTelephone = listTelephone;
    }

    public void setListAddress(List<Address> listAddress) {
        this.listAddress = listAddress;
    }

    /**
     * Método que válida o cpf ou cnpj que vem de fora da entidade
     * @param value - natureza do cliente, caso for 0 pessoa fisica, e caso for 1 pessoa juridica
     * @param cpfOrCnpj - valor do CPF ou CNPJ
     */
    private void verificarCpfOuCnpj(Integer value, String cpfOrCnpj){
        if (value == 0){
            this.cpf = cpfOrCnpj;
        } else if (value ==1) {
            this.cnpj = cpfOrCnpj;
        } else {
            throw new InvalidNatureCustomer("CPF OR CNPJ NOT VALID");
        }
    }

    /**
     * Método para setar a natureza
     * @param value - natureza do cliente, caso for 0 pessoa fisica, e caso for 1 pessoa juridica
     */
    public void setNature(Integer value){
        if (value == 0){
            this.nature = Nature.PESSOA_FISICA;
        } if (value == 1){
            this.nature = Nature.PESSOA_JURIDICA;
        }
    }

    /**
     * Método que válida o cpf ou cnpj que vem do banco de dados
     * @param cpfOrCnpj - valor do CPF ou CNPJ
     */
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
