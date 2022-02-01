package br.com.udemy.Spring.FullStack.form.atualizar;

import br.com.udemy.Spring.FullStack.services.EmailService;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailDto {

    @NotEmpty
    @Email(message = "E-mail Inválido")
    private String email;

    public EmailDto(){}

    public EmailDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
