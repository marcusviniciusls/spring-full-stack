package br.com.udemy.Spring.FullStack.form.atualizar;

public class CategoriaRefresh {

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
