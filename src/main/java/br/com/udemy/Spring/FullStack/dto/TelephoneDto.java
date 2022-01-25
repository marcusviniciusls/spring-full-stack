package br.com.udemy.Spring.FullStack.dto;

public class TelephoneDto {

    private String ddd;
    private String telephone;

    public TelephoneDto(String ddd, String telephone) {
        this.ddd = ddd;
        this.telephone = telephone;
    }

    public String getDdd() {
        return ddd;
    }

    public String getTelephone() {
        return telephone;
    }
}
