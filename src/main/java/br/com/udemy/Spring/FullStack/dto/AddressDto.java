package br.com.udemy.Spring.FullStack.dto;

/**
 * Classe Data Transfer Object (Dto) para a entidade Address
 */
public class AddressDto {

    // Atributos
    private String logadouro;
    private String number;
    private String complement;
    private String district;
    private String cep;

    // Construtores
    public AddressDto(String logadouro, String number, String complement, String district, String cep) {
        this.logadouro = logadouro;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.cep = cep;
    }

    public AddressDto(){}

    // Métodos Gets e Sets
    public String getLogadouro() {
        return logadouro;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getDistrict() {
        return district;
    }

    public String getCep() {
        return cep;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
