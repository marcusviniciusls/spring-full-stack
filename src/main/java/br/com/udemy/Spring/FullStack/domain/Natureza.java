package br.com.udemy.Spring.FullStack.domain;

public enum Natureza {    
    PESSOA_FISICA(1),
    PESSOA_JURIDICA(2);
    
    private int valor;

    Natureza(int i) {
        this.valor = i;    
    }
}
