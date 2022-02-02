package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.State;
import br.com.udemy.Spring.FullStack.dto.StateDto;

public class StateBusinessRule {

    public static StateDto convertPageStateInPageStateDto(State state){
        return new StateDto(state.getName());
    }
}
