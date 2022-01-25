package br.com.udemy.Spring.FullStack.resources;

import br.com.udemy.Spring.FullStack.dto.ClienteDto;
import br.com.udemy.Spring.FullStack.form.atualizar.ClientRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.ClientForm;
import br.com.udemy.Spring.FullStack.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "cliente")
public class ClienteResource {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDto> findByCliente(@PathVariable UUID id){
        ClienteDto clientDto = clienteService.findById(id);
        return ResponseEntity.ok().body(clientDto);
    }
    
    @GetMapping
    public ResponseEntity<Page<ClienteDto>> findByAllCliente(
            @RequestParam(value="page", defaultValue = "0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue = "10") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value="direction", defaultValue = "DESC") String direction
    ){
        Page<ClienteDto> listClienteDto = clienteService.findByAll(page,linesPerPage,orderBy,direction);
        return ResponseEntity.ok().body(listClienteDto);
    }

    @PostMapping
    public ResponseEntity<?> saveClient(@Valid @RequestBody ClientForm clientForm){
        clienteService.saveClient(clientForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> refreshClient(@Valid @RequestBody ClientRefresh clientRefresh, @PathVariable UUID id){
        clienteService.updateClient(clientRefresh, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable UUID id){
        clienteService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
