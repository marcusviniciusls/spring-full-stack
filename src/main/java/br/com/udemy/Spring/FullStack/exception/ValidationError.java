package br.com.udemy.Spring.FullStack.exception;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que extends de StandardError
 */
public class ValidationError extends StandardError{

    // Atributos
    private List<FieldMessage> listFieldMessage = new ArrayList<>();

    // Construtores
    public ValidationError(Instant timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public List<FieldMessage> getListFieldMessage() {
        return listFieldMessage;
    }

    public void addListFieldMessage(String fieldName, String message) {
        this.listFieldMessage.add(new FieldMessage(fieldName,message));
    }
}
