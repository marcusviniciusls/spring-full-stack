package br.com.udemy.Spring.FullStack.exception;

/**
 * Classe que implementa exception
 */
public class InvalidCpfCnpj extends Exception{

    // Construtores
    public InvalidCpfCnpj(String message) {
        super("ERROR VALIDATION CPF AND CNPJ" + message);
    }
}
