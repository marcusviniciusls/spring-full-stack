package br.com.udemy.Spring.FullStack.resources;

import br.com.udemy.Spring.FullStack.dto.ClientDto;
import br.com.udemy.Spring.FullStack.form.atualizar.ClientRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.ClientForm;
import br.com.udemy.Spring.FullStack.form.salvar.ClientFormFull;
import br.com.udemy.Spring.FullStack.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * Rest Controller de Client
 */
@RestController
@RequestMapping(value = "client")
public class ClientResource {
    
    @Autowired
    private ClientService clientService;

    /**
     * Busca o Client por id
     * @param id - Recebe o id do Client para ser buscado
     * @return - Retorna o ClientDto
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDto> findByCliente(@PathVariable UUID id){
        ClientDto clientDto = clientService.findById(id);
        return ResponseEntity.ok().body(clientDto);
    }
    /**
     * Método para buscar todos os Client do Banco de Dados
     * @param page - Qual a página que quero mostrar
     * @param linesPerPage - Quantidade de registro por página
     * @param orderBy - Ordenação qual campo
     * @param direction - Ascendente e Descendente
     * @return - retorna uma lista de ClientDto
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
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

    /**
     * Método para salvar um novo Client
     * @param clientForm - Recebe as informações do novo Client
     * @return - Retorna um ok caso de certo o salvamento
     */
    @PostMapping
    public ResponseEntity<?> saveClient(@Valid @RequestBody ClientForm clientForm){
        clientService.saveClient(clientForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Método para salvar um cliente completo com todas as informações
     * @param clientFormFull - Recebe dados do cliente para salvar no banco de dados
     * @return retorna criado caso de tudo certo
     */
    @PostMapping(value = "full")
    public ResponseEntity<?> saveClientFull(@Valid @RequestBody ClientFormFull clientFormFull){
        clientService.saveClientFull(clientFormFull);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Atualizao o Client por um Id
     * @param clientRefresh - Recebe as informações para atualizar o Client
     * @param id - Recebe o id de quem será atualizado
     * @return - Retorna um ok caso de certo
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> refreshClient(@Valid @RequestBody ClientRefresh clientRefresh, @PathVariable UUID id){
        clientService.updateClient(clientRefresh, id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Deleta um Client por ID
     * @param id - Recebe o id de quem será excluído
     * @return - Retorna ok caso de certo
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable UUID id){
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "picture")
    public ResponseEntity<?> uploadProfilePicture(@RequestParam(name="file") MultipartFile multipartFile){
        URI uri = clientService.uploadProfilePicture(multipartFile);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/email")
    public ResponseEntity<ClientDto> findByClientePerEmail(@RequestParam(value = "value") String email){
        ClientDto clientDto = clientService.findByClientPerEmail(email);
        return ResponseEntity.ok().body(clientDto);
    }
}
