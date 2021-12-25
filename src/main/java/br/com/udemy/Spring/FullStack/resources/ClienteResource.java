package br.com.udemy.Spring.FullStack.resources;

import br.com.udemy.Spring.FullStack.dto.ClienteDto;
import br.com.udemy.Spring.FullStack.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<ClienteDto>> findByAllCliente(){
        List<ClienteDto> listClienteDto = clienteService.findByAll();
        return ResponseEntity.ok().body(listClienteDto);
    }
}
