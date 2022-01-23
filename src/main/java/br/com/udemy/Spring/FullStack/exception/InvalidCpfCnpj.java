package br.com.udemy.Spring.FullStack.exception;

public class InvalidCpfCnpj extends Exception{

    public InvalidCpfCnpj(String message) {
        super("Error Validation CPF AND CNPJ" + message);
    }
}
