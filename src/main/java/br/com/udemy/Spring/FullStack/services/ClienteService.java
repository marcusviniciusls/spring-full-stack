package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.Cliente;
import br.com.udemy.Spring.FullStack.dto.ClienteDto;
import br.com.udemy.Spring.FullStack.exception.ResourceNotFoundException;
import br.com.udemy.Spring.FullStack.factory.ClienteBusinessRule;
import br.com.udemy.Spring.FullStack.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    public List<ClienteDto> findByAll(){
        List<Cliente> listCliente = clienteRepository.findAll();
        List<ClienteDto> listClienteDto = new ArrayList<>();
        ClienteBusinessRule clienteBusinessRule = new ClienteBusinessRule();
        for (Cliente cliente : listCliente){
            listClienteDto.add(clienteBusinessRule.convertClientDto(cliente));    
        }
        return listClienteDto;
    }
}
