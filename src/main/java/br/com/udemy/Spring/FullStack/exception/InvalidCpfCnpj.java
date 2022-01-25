package br.com.udemy.Spring.FullStack.exception;

public class InvalidCpfCnpj extends Exception{

    public InvalidCpfCnpj(String message) {
        super("ERROR VALIDATION CPF AND CNPJ" + message);
    }
}
