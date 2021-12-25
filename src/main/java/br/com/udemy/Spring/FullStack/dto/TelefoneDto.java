package br.com.udemy.Spring.FullStack.dto;

public class TelefoneDto {

    private String ddd;
    private String telefone;

    public TelefoneDto(String ddd, String telefone) {
        this.ddd = ddd;
        this.telefone = telefone;
    }

    public String getDdd() {
        return ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "TelefoneDto{" +
                "ddd='" + ddd + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
