package br.com.udemy.Spring.FullStack.form.salvar;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * Campos necessários para criar uma nova Categoria
 */
public class CategoryForm {

    // Atributos
    @NotEmpty(message = "Name cannot be null")
    @Length(min = 5, message = "Minimum size 5 characters")
    private String name;

    // Construtores
    public CategoryForm(String name) {
        this.name = name;
    }

    public CategoryForm(){}

    // Métodos Gets e Sets
    public String getName() {
        return name;
    }
}
