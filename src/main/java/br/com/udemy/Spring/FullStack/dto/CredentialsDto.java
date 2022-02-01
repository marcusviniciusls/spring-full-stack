package br.com.udemy.Spring.FullStack.dto;

public class CredentialsDto {

    // Atributo
    private String email;
    private String password;

    // Construtores
    public CredentialsDto(){}

    public CredentialsDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Métodos Gets e Sets
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
