package br.com.udemy.Spring.FullStack.exception;

public class InvalidNatureCustomer extends RuntimeException{

    public InvalidNatureCustomer(String invalid_nature_customer) {
        super("INVALID CUSTOMER NATURE");
    }
}
