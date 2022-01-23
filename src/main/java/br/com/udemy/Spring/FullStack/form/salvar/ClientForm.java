package br.com.udemy.Spring.FullStack.form.salvar;

import javax.validation.constraints.NotNull;

public class ClientForm {

    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private Integer natureza;
    @NotNull
    private String cpfOuCnpj;

    public ClientForm(String nome, String email, Integer natureza, String cpfOuCnpj) {
        this.nome = nome;
        this.email = email;
        this.natureza = natureza;
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNatureza() {
        return natureza;
    }

    public void setNatureza(Integer natureza) {
        this.natureza = natureza;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }
}
