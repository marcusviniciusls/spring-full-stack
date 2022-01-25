package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Client;
import br.com.udemy.Spring.FullStack.dto.ClientDto;
import br.com.udemy.Spring.FullStack.exception.ResourceNotFoundException;
import br.com.udemy.Spring.FullStack.factory.ClientBusinessRule;
import br.com.udemy.Spring.FullStack.form.atualizar.ClientRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.ClientForm;
import br.com.udemy.Spring.FullStack.repositorys.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Regra de Negócio Centralizado: Client
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    /**
     * Busca um Client por id
     * @param id - Recebe o id para pesquisar o Client
     * @return - Retorna o ClientDto encontrado
     */
    public ClientDto findById(UUID id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isEmpty()){
            throw new ResourceNotFoundException("ID CLIENT NOT FOUND");
        }
        Client client = optionalClient.get();
        ClientBusinessRule clientBusinessRule = new ClientBusinessRule();
        
        return clientBusinessRule.convertClientDto(client);
    }

    /**
     * Busca todos os Client do Banco de Dados
     * @param page - Qual a página motrar
     * @param linesPerPage Quantas linhas por página
     * @param orderBy - Qual campo será ordenado
     * @param direction - Qual direção ASC ou DESC
     * @return - Retorna uma Lista de ClientDto
     */
    public Page<ClientDto> findByAll(Integer page, Integer linesPerPage, String orderBy, String direction){
        Pageable pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        Page<Client> listClient = clientRepository.findAll(pageRequest);
        Page<ClientDto> listClientDto = listClient.map(ClientBusinessRule::convertClientDto);
        return listClientDto;
    }

    /**
     * Salva um novo Client no Banco de Dados
     * @param clientForm - Recebe as informações do novo Client
     */
    public void saveClient(ClientForm clientForm){
        Client client = ClientBusinessRule.convertClientFormInClient(clientForm);
        clientRepository.save(client);
    }

    /**
     * Atualiza um Client no Banco de Dados
     * @param clientRefresh - Recebe as informações para a atualização
     * @param id - Recebe o id de qual Client deverá ser atualziado
     */
    public void updateClient(ClientRefresh clientRefresh, UUID id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isEmpty()){
            throw new ResourceNotFoundException("Client Not Found Exception");
        }
        Client client = optionalClient.get();
        Client clientUpdate = ClientBusinessRule.refreshClient(client,clientRefresh);
        clientRepository.save(clientUpdate);
    }

    /**
     * Deleta um Client por ID
     * @param id - Recebe o id do Client que deverá ser excluido
     */
    public void deleteClient(UUID id){
        try{
            clientRepository.deleteById(id);
        } catch(DataIntegrityViolationException dataIntegrityViolationException){
            Client client = clientRepository.findById(id).get();
            Client clientAlter = ClientBusinessRule.deleteClient(client);
            clientRepository.save(clientAlter);
        }
    }
}
