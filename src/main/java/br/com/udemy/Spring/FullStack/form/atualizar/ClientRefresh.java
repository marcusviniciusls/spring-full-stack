package br.com.udemy.Spring.FullStack.form.atualizar;

public class ClientRefresh {

    private String nome;
    private String email;
    private Integer natureza;
    private String cpfOuCnpj;

    public ClientRefresh(String nome, String email, Integer natureza, String cpfOuCnpj) {
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
