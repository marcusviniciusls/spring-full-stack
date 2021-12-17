package br.com.udemy.Spring.FullStack.dto;

public class EnderecoDto {

    private String logadouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    public EnderecoDto(String logadouro, String numero, String complemento, String bairro, String cep) {
        this.logadouro = logadouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }
}
