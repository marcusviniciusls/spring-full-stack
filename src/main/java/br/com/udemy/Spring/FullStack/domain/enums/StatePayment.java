package br.com.udemy.Spring.FullStack.domain.enums;

public enum StatePayment {
    
    PENDENTE(1),
    QUITADO(2),
    CANCELADO(3);

    private int value;

    StatePayment(int i) {
        this.value = i;
    }
}
