package br.com.udemy.Spring.FullStack.resources;

import br.com.udemy.Spring.FullStack.dto.ClientDto;
import br.com.udemy.Spring.FullStack.dto.StateDto;
import br.com.udemy.Spring.FullStack.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "state")
public class StateResource {

    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity<Page<StateDto>> findByAllState(
            @RequestParam(value="page", defaultValue = "0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue = "10") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value="direction", defaultValue = "DESC") String direction
    ){
        Page<StateDto> listStateDto = stateService.findByAllStates(page,linesPerPage,orderBy,direction);
        return ResponseEntity.ok().body(listStateDto);
    }
}
