package br.com.udemy.Spring.FullStack.dto;

public class StateDto {

    // Atributos
    private String nameState;

    // Construtores
    public StateDto(){}

    public StateDto(String nameState) {
        this.nameState = nameState;
    }

    // Métodos Gets e Sets
    public String getNameState() {
        return nameState;
    }

    public void setNameState(String nameState) {
        this.nameState = nameState;
    }
}
