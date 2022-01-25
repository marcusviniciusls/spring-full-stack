package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Client;
import br.com.udemy.Spring.FullStack.domain.Address;
import br.com.udemy.Spring.FullStack.domain.Telephone;
import br.com.udemy.Spring.FullStack.domain.enums.Nature;
import br.com.udemy.Spring.FullStack.dto.ClientDto;
import br.com.udemy.Spring.FullStack.dto.AddressDto;
import br.com.udemy.Spring.FullStack.dto.TelephoneDto;
import br.com.udemy.Spring.FullStack.exception.InvalidNatureCustomer;
import br.com.udemy.Spring.FullStack.form.atualizar.ClientRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.ClientForm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClientBusinessRule {
    
    public static ClientDto convertClientDto(Client client){
        ClientDto clientDto = new ClientDto();
        
        clientDto.setEmail(client.getEmail());
        clientDto.setNature(client.getNature());
        clientDto.setName(client.getName());
        setNaturezaCPFouCNPJ(clientDto,client);
        clientDto.setListTelephones(setListTelefone(client.getListTelephone()));
        clientDto.setListAddress(setListEndereco(client.getListAddress()));
        
        return clientDto;
        
    }
    
    private static void setNaturezaCPFouCNPJ(ClientDto clientDto, Client client){
        if (client.getNature() == Nature.PESSOA_FISICA){
            clientDto.setCpf(client.getCpf());
        } else if (client.getNature() == Nature.PESSOA_JURIDICA){
            clientDto.setCnpj(client.getCnpj());
        } else {
            throw new InvalidNatureCustomer("Invalid Nature Customer");
        }
    }
    
    private static List<TelephoneDto> setListTelefone(List<Telephone> listTelephoneClient){
        List<TelephoneDto> listTelephoneDto = new ArrayList<>();
        for (Telephone telephone : listTelephoneClient){
            listTelephoneDto.add(convertTelefoneDto(telephone));
        }
        return listTelephoneDto;
    }
    
    private static TelephoneDto convertTelefoneDto(Telephone telephone){
        return new TelephoneDto(telephone.getDdd(),telephone.getTelephone());
    }
    
    private static List<AddressDto> setListEndereco(List<Address> listAddressClient){
        List<AddressDto> ListAddressDto = new ArrayList<>();
        for (Address address : listAddressClient){
            ListAddressDto.add(convertEnderecoDto(address));
        }
        return ListAddressDto;
    }
    
    private static AddressDto convertEnderecoDto(Address address){
        return new AddressDto(address.getAddress(), address.getNumber(), address.getComplement(), address.getDistrict(), address.getCep());
    }

    public static Client convertClientFormInClient(ClientForm clientForm){
        Client client = new Client(clientForm.getName(), clientForm.getEmail(), clientForm.getNature(), clientForm.getCpfOrCnpj());
        return client;
    }

    public static Client refreshClient(Client client, ClientRefresh clientRefresh){
        if (clientRefresh.getName() != null){
            client.setName(clientRefresh.getName());
        } if (clientRefresh.getEmail() != null){
            client.setEmail(clientRefresh.getEmail());
        } if (clientRefresh.getNature() != null){
            client.setNature(clientRefresh.getNature());
        } if (clientRefresh.getCpfOrCnpj() != null){
            client.verificarCpfOuCnpjEntidadeCliente(clientRefresh.getCpfOrCnpj());
        }
        refreshDataAtualizacao(client);

        return client;
    }

    private static void refreshDataAtualizacao(Client client){
        client.setDateUpdate(LocalDateTime.now());
    }

    public static Client deleteClient(Client client){
        client.setStatus(false);
        return client;
    }
}
