package br.com.udemy.Spring.FullStack.domain.enums;

/**
 * Enum que defini o estado de cada pagamento
 */
public enum StatePayment {
    
    PENDENTE(1),
    QUITADO(2),
    CANCELADO(3);

    private int value;

    StatePayment(int i) {
        this.value = i;
    }
}
