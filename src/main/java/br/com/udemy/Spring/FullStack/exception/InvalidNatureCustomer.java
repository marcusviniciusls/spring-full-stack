package br.com.udemy.Spring.FullStack.exception;

/**
 * Classe que implementa a exceção RuntimeException
 */
public class InvalidNatureCustomer extends RuntimeException{

    // Construtores
    public InvalidNatureCustomer(String invalid_nature_customer) {
        super("INVALID CUSTOMER NATURE");
    }
}
