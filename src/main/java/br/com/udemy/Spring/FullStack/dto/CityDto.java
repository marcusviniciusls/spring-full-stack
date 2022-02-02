package br.com.udemy.Spring.FullStack.dto;

import java.util.ArrayList;
import java.util.List;

public class CityDto {

    //Atributos
    private String name;
    private StateDto stateDto;

    // Construtores
    public CityDto(){}

    //Método Get e Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StateDto getStateDto() {
        return stateDto;
    }

    public void setStateDto(StateDto stateDto) {
        this.stateDto = stateDto;
    }
}
