package br.com.udemy.Spring.FullStack.form.salvar;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * Classe que contém campos para salvar um no Client
 */
public class ClientFormFull extends ClientForm{

    // Atributos
    @NotEmpty(message = "Name cannot be null")
    private String ddd;
    @NotEmpty(message = "Name cannot be null")
    private String telephone;
    private String ddd2;
    private String telephone2;
    private String ddd3;
    private String telephone3;
    @NotEmpty(message = "Name cannot be null")
    private String address;
    @NotEmpty(message = "Name cannot be null")
    private String number;
    private String complement;
    @NotEmpty(message = "Name cannot be null")
    private String district;
    @NotEmpty(message = "Name cannot be null")
    private String cep;
    @NotEmpty(message = "Name cannot be null")
    private String city;
    @NotEmpty(message = "Name cannot be null")
    private String uf;
    @NotEmpty(message = "Name cannot be null")
    private String password;

    // Construtores
    public ClientFormFull(String name, String email, Integer nature, String cpfOrCnpj, String ddd, String telephone, String address, String number, String district, String cep, String city, String uf) {
        super(name, email, nature, cpfOrCnpj);
        this.ddd = ddd;
        this.telephone = telephone;
        this.address = address;
        this.number = number;
        this.district = district;
        this.cep = cep;
        this.city = city;
    }

    public ClientFormFull() {
    }

    // Métodos Gets e Sets
    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDdd2() {
        return ddd2;
    }

    public void setDdd2(String ddd2) {
        this.ddd2 = ddd2;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getDdd3() {
        return ddd3;
    }

    public void setDdd3(String ddd3) {
        this.ddd3 = ddd3;
    }

    public String getTelephone3() {
        return telephone3;
    }

    public void setTelephone3(String telephone3) {
        this.telephone3 = telephone3;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
