package br.com.udemy.Spring.FullStack.form.salvar;

import javax.validation.constraints.NotNull;

public class ClientForm {

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private Integer nature;
    @NotNull
    private String cpfOrCnpj;

    public ClientForm(String name, String email, Integer nature, String cpfOrCnpj) {
        this.name = name;
        this.email = email;
        this.nature = nature;
        this.cpfOrCnpj = cpfOrCnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }
}
