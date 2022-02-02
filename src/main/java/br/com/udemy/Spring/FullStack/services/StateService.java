package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.State;
import br.com.udemy.Spring.FullStack.dto.StateDto;
import br.com.udemy.Spring.FullStack.factory.StateBusinessRule;
import br.com.udemy.Spring.FullStack.repositorys.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public Page<StateDto> findByAllStates(Integer page, Integer linesPerPage, String orderBy, String direction){
        Pageable pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        Page<State> pageState =  stateRepository.findByAllStateOrderByName(pageRequest);
        Page<StateDto> pageStateDto = pageState.map(StateBusinessRule::convertPageStateInPageStateDto);
        return pageStateDto;
    }
}
