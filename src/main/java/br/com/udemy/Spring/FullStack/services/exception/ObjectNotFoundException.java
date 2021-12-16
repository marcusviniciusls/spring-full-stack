package br.com.udemy.Spring.FullStack.services.exception;

public class ObjectNotFoundException extends RuntimeException{
     
    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg,cause);
    }

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
