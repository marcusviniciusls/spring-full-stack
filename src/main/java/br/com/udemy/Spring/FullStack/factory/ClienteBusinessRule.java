package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Cliente;
import br.com.udemy.Spring.FullStack.domain.Endereco;
import br.com.udemy.Spring.FullStack.domain.Telefone;
import br.com.udemy.Spring.FullStack.domain.enums.Natureza;
import br.com.udemy.Spring.FullStack.dto.ClienteDto;
import br.com.udemy.Spring.FullStack.dto.EnderecoDto;
import br.com.udemy.Spring.FullStack.dto.TelefoneDto;
import br.com.udemy.Spring.FullStack.exception.InvalidNatureCustomer;

import java.util.ArrayList;
import java.util.List;

public class ClienteBusinessRule {
    
    public ClienteDto convertClientDto(Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();
        
        clienteDto.setEmail(cliente.getEmail());
        clienteDto.setNatureza(cliente.getNatureza());
        clienteDto.setNome(cliente.getNome());
        setNaturezaCPFouCNPJ(clienteDto,cliente);
        clienteDto.setListTelefones(setListTelefone(cliente.getListaTelefones()));
        clienteDto.setListEnderecos(setListEndereco(cliente.getListaEnderecos()));
        
        return clienteDto;      
        
    }
    
    private void setNaturezaCPFouCNPJ(ClienteDto clienteDto, Cliente cliente){
        if (cliente.getNatureza() == Natureza.PESSOA_FISICA){
            clienteDto.setCpf(cliente.getCpf());
        } else if (cliente.getNatureza() == Natureza.PESSOA_JURIDICA){
            clienteDto.setCnpj(cliente.getCnpj());
        } else {
            throw new InvalidNatureCustomer("Invalid Nature Customer");
        }
    }
    
    private List<TelefoneDto> setListTelefone(List<Telefone> listTelefoneCliente){
        List<TelefoneDto> listTelefoneDto = new ArrayList<>();
        for (Telefone telefone : listTelefoneCliente){
            listTelefoneDto.add(convertTelefoneDto(telefone));    
        }
        return listTelefoneDto;
    }
    
    private TelefoneDto convertTelefoneDto(Telefone telefone){
        return new TelefoneDto(telefone.getDdd(),telefone.getTelefone());
    }
    
    private List<EnderecoDto> setListEndereco(List<Endereco> listEnderecoCliente){
        List<EnderecoDto> listEnderecoDto = new ArrayList<>();
        for (Endereco endereco : listEnderecoCliente){
            listEnderecoDto.add(convertEnderecoDto(endereco));
        }
        return listEnderecoDto;
    }
    
    private EnderecoDto convertEnderecoDto(Endereco endereco){
        return new EnderecoDto(endereco.getLogadouro(), endereco.getNumero(), endereco.getComplemento(), endereco.getBairro(), endereco.getCep());
    }
}
