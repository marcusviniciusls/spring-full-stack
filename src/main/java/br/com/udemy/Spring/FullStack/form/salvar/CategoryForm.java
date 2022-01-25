package br.com.udemy.Spring.FullStack.form.salvar;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CategoryForm {

    @NotEmpty(message = "Name cannot be null")
    @Length(min = 5, message = "Minimum size 5 characters")
    private String name;

    public CategoryForm(String name) {
        this.name = name;
    }

    public CategoryForm(){}

    public String getName() {
        return name;
    }
}
