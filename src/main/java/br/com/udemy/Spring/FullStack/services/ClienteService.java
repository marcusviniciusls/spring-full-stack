package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Cliente;
import br.com.udemy.Spring.FullStack.dto.ClienteDto;
import br.com.udemy.Spring.FullStack.exception.ResourceNotFoundException;
import br.com.udemy.Spring.FullStack.factory.ClienteBusinessRule;
import br.com.udemy.Spring.FullStack.form.atualizar.ClientRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.ClientForm;
import br.com.udemy.Spring.FullStack.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public ClienteDto findById(UUID id){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id); 
        if (clienteOptional.isEmpty()){
            throw new ResourceNotFoundException("ID CLIENT NOT FOUND");
        }
        Cliente cliente = clienteOptional.get();
        ClienteBusinessRule clienteBusinessRule = new ClienteBusinessRule();
        
        return clienteBusinessRule.convertClientDto(cliente);
    }
    
    public Page<ClienteDto> findByAll(Integer page, Integer linesPerPage, String orderBy, String direction){
        Pageable pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        Page<Cliente> listCliente = clienteRepository.findAll(pageRequest);
        Page<ClienteDto> listClienteDto = listCliente.map(ClienteBusinessRule::convertClientDto);
        return listClienteDto;
    }

    public void saveClient(ClientForm clientForm){
        Cliente cliente = ClienteBusinessRule.convertClientFormInClient(clientForm);
        clienteRepository.save(cliente);
    }

    public void updateClient(ClientRefresh clientRefresh, UUID id){
        Optional<Cliente> optionalClient = clienteRepository.findById(id);
        if (optionalClient.isEmpty()){
            throw new ResourceNotFoundException("Client Not Found Exception");
        }
        Cliente cliente = optionalClient.get();
        Cliente clienteAtualizado = ClienteBusinessRule.refreshClient(cliente,clientRefresh);
        clienteRepository.save(clienteAtualizado);
    }
    public void deleteClient(UUID id){
        try{
            clienteRepository.deleteById(id);
        } catch(DataIntegrityViolationException dataIntegrityViolationException){
            Cliente client = clienteRepository.findById(id).get();
            Cliente clientAlterado = ClienteBusinessRule.deleteClient(client);
            clienteRepository.save(clientAlterado);
        }
    }
}
