package br.com.udemy.Spring.FullStack.domain.enums;

public enum EstadoPagamento {
    
    PENDENTE(1),
    QUITADO(2),
    CANCELADO(3);

    private int valor;

    EstadoPagamento(int i) {
        this.valor = i;
    }
}
