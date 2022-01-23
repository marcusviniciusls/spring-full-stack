package br.com.udemy.Spring.FullStack.form.atualizar;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CategoriaRefresh {

    @NotEmpty(message = "Nome não pode ser nulo")
    @Length(min = 5, message = "Tamanho minimo 5 caracteres")
    private String nomeCategoria;

    public CategoriaRefresh(){}

    public CategoriaRefresh(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
