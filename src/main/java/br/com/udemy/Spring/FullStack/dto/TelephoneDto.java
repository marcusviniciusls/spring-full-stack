package br.com.udemy.Spring.FullStack.dto;

/**
 * Classe Data Transfer Object (Dto) para a entidade Telephone
 */
public class TelephoneDto {

    // Atributos
    private String ddd;
    private String telephone;

    // Construtores
    public TelephoneDto(String ddd, String telephone) {
        this.ddd = ddd;
        this.telephone = telephone;
    }

    // Métodos gets e sets
    public String getDdd() {
        return ddd;
    }

    public String getTelephone() {
        return telephone;
    }
}
