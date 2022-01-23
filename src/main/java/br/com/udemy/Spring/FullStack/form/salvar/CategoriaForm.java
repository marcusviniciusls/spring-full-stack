package br.com.udemy.Spring.FullStack.form.salvar;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CategoriaForm {

    @NotEmpty(message = "Nome não pode ser nulo")
    @Length(min = 5, message = "Tamanho minimo 5 caracteres")
    private String nome;

    public CategoriaForm(String nome) {
        this.nome = nome;
    }

    public CategoriaForm(){}

    public String getNome() {
        return nome;
    }
}
