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

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public ClientDto findById(UUID id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isEmpty()){
            throw new ResourceNotFoundException("ID CLIENT NOT FOUND");
        }
        Client client = optionalClient.get();
        ClientBusinessRule clientBusinessRule = new ClientBusinessRule();
        
        return clientBusinessRule.convertClientDto(client);
    }
    
    public Page<ClientDto> findByAll(Integer page, Integer linesPerPage, String orderBy, String direction){
        Pageable pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        Page<Client> listClient = clientRepository.findAll(pageRequest);
        Page<ClientDto> listClientDto = listClient.map(ClientBusinessRule::convertClientDto);
        return listClientDto;
    }

    public void saveClient(ClientForm clientForm){
        Client client = ClientBusinessRule.convertClientFormInClient(clientForm);
        clientRepository.save(client);
    }

    public void updateClient(ClientRefresh clientRefresh, UUID id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isEmpty()){
            throw new ResourceNotFoundException("Client Not Found Exception");
        }
        Client client = optionalClient.get();
        Client clientUpdate = ClientBusinessRule.refreshClient(client,clientRefresh);
        clientRepository.save(clientUpdate);
    }
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
