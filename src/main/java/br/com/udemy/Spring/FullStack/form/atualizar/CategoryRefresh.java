package br.com.udemy.Spring.FullStack.form.atualizar;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CategoryRefresh {

    @NotEmpty(message = "Name cannot be null")
    @Length(min = 5, message = "Minimum size 5 characters")
    private String nameCategory;

    public CategoryRefresh(){}

    public CategoryRefresh(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
