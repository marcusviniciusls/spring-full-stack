package br.com.udemy.Spring.FullStack.exception;

/**
 * Classe que implementa como deve se tratar o error quando alguma campo não é preenchido.
 */
public class FieldMessage {

    // Atributos
    private String fieldName;
    private String message;

    // Construtores
    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public FieldMessage(){}

    // Métodos Gets e Sets
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
