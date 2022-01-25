package br.com.udemy.Spring.FullStack.exception;

/**
 * Excessão que lança o ResourceNotFoundException
 */
public class ResourceNotFoundException extends RuntimeException{

    // Construtores
    public ResourceNotFoundException(Object id){
        super("RESOURCE NOT FOUND ID " + id);
    }
}
