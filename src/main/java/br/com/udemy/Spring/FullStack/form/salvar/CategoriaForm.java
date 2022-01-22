package br.com.udemy.Spring.FullStack.form.salvar;

import com.sun.istack.NotNull;
import org.hibernate.annotations.NotFound;

public class CategoriaForm {

    @NotNull
    @NotFound
    private String nome;

    public CategoriaForm(String nome) {
        this.nome = nome;
    }

    public CategoriaForm(){}

    public String getNome() {
        return nome;
    }
}
