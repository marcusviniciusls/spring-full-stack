package br.com.udemy.Spring.FullStack.resources;

import br.com.udemy.Spring.FullStack.dto.ClientDto;
import br.com.udemy.Spring.FullStack.form.atualizar.ClientRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.ClientForm;
import br.com.udemy.Spring.FullStack.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "client")
public class ClientResource {
    
    @Autowired
    private ClientService clientService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDto> findByCliente(@PathVariable UUID id){
        ClientDto clientDto = clientService.findById(id);
        return ResponseEntity.ok().body(clientDto);
    }
    
    @GetMapping
    public ResponseEntity<Page<ClientDto>> findByAllCliente(
            @RequestParam(value="page", defaultValue = "0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue = "10") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value="direction", defaultValue = "DESC") String direction
    ){
        Page<ClientDto> listClientDto = clientService.findByAll(page,linesPerPage,orderBy,direction);
        return ResponseEntity.ok().body(listClientDto);
    }

    @PostMapping
    public ResponseEntity<?> saveClient(@Valid @RequestBody ClientForm clientForm){
        clientService.saveClient(clientForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> refreshClient(@Valid @RequestBody ClientRefresh clientRefresh, @PathVariable UUID id){
        clientService.updateClient(clientRefresh, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable UUID id){
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
