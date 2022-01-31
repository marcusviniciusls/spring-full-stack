package br.com.udemy.Spring.FullStack.factory;

import br.com.udemy.Spring.FullStack.domain.Client;
import br.com.udemy.Spring.FullStack.domain.Address;
import br.com.udemy.Spring.FullStack.domain.Telephone;
import br.com.udemy.Spring.FullStack.domain.enums.Nature;
import br.com.udemy.Spring.FullStack.dto.ClientDto;
import br.com.udemy.Spring.FullStack.dto.AddressDto;
import br.com.udemy.Spring.FullStack.dto.TelephoneDto;
import br.com.udemy.Spring.FullStack.exception.InvalidNatureCustomer;
import br.com.udemy.Spring.FullStack.exception.ResourceNotFoundException;
import br.com.udemy.Spring.FullStack.form.atualizar.ClientRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.ClientForm;
import br.com.udemy.Spring.FullStack.repositorys.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Classe que contém regras de negócios para a entidade Client
 */
@Service
public class ClientBusinessRule {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Converte um objeto do tipo Cleint em ClientDto
     * @param client - recebe um objeto do tipo Client
     * @return - retorna um objeto do tipo ClientDto
     */
    public static ClientDto convertClientDto(Client client){
        ClientDto clientDto = new ClientDto();
        
        clientDto.setEmail(client.getEmail());
        clientDto.setNature(client.getNature());
        clientDto.setName(client.getNome());
        setNatureCpfOrCnpj(clientDto,client);
        clientDto.setListTelephones(setListTelephone(client.getListTelephone()));
        clientDto.setListAddress(setListAddress(client.getListAddress()));

        return clientDto;
 }

    /**
     * Regra para setar o CPF ou CNPJ para o ClientDto
     * @param clientDto - ClientDto para atualizar
     * @param client - Client antigo
     */
    private static void setNatureCpfOrCnpj(ClientDto clientDto, Client client){
        if (client.getNature() == Nature.PESSOA_FISICA){
            clientDto.setCpf(client.getCpf());
        } else if (client.getNature() == Nature.PESSOA_JURIDICA){
            clientDto.setCnpj(client.getCnpj());
        } else {
            throw new InvalidNatureCustomer("Invalid Nature Customer");
        }
    }

    /**
     * Método que traz todos os endereços para o clientDto
     * @param listTelephoneClient - recebe uma lista de Telefones do cliente para transformar em TelefoneDto
     * @return - retorna uma lista de telefonesDto
     */
    private static List<TelephoneDto> setListTelephone(List<Telephone> listTelephoneClient){
        List<TelephoneDto> listTelephoneDto = new ArrayList<>();
        for (Telephone telephone : listTelephoneClient){
            listTelephoneDto.add(convertTelephoneDto(telephone));
        }
        return listTelephoneDto;
    }

    /**
     * Converte o objeto do tipo Telephone em TelephoneDto
     * @param telephone - recebe um objeto do tipo Telephone
     * @return - retorna um objeto do tipo TelephoneDto
     */
    private static TelephoneDto convertTelephoneDto(Telephone telephone){
        return new TelephoneDto(telephone.getDdd(),telephone.getTelephone());
    }

    /**
     * Converte uma lista de AddressClient em AddressDto
     * @param listAddressClient - recebe uma lista de AddressClient
     * @return - retorna uma lista de AddresDto
     */
    private static List<AddressDto> setListAddress(List<Address> listAddressClient){
        List<AddressDto> ListAddressDto = new ArrayList<>();
        for (Address address : listAddressClient){
            ListAddressDto.add(convertAddressDto(address));
        }
        return ListAddressDto;
    }

    /**
     * Converte um objeto do tipo Address em AddressDto
     * @param address - recebe um objeto do tipo Address
     * @return - retorna um objeto do tipo de AddressDto
     */
    private static AddressDto convertAddressDto(Address address){
        return new AddressDto(address.getAddress(), address.getNumber(), address.getComplement(), address.getDistrict(), address.getCep());
    }

    /**
     * Converte um objeto do tipo ClientForm em Client
     * @param clientForm - recebe um objeto do tipo ClientForm
     * @return - retorna um objeto do tipo Client
     */
    public static Client convertClientFormInClient(ClientForm clientForm){
        Client client = new Client(clientForm.getName(), clientForm.getEmail(), clientForm.getNature(), clientForm.getCpfOrCnpj());
        return client;
    }

    /**
     * Método que atualiza um cliente para salvar no banco de dados
     * @param client - Recebe um objeto do tipo de Client que venho do Banco de Dados
     * @param clientRefresh - Recebe um objeto do tipo ClientRefresh  que vem de fora da API
     * @return - Retorna o objeto atualizado
     */
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

    /**
     * Atualiza a data de atualização do registro no Banco de Dados
     * @param client - Recebe um Client do banco de dados.
     */
    private static void refreshDataAtualizacao(Client client){
        client.setDateUpdate(LocalDateTime.now());
    }

    /**
     * Marca como excluido um item no banco de dados quando
     * @param client - Recebe um client que venho do banco de dados
     * @return - Retorna um objeto atualizado
     */
    public static Client deleteClient(Client client){
        client.setStatus(false);
        return client;
    }

    public static Client checkClientMarkedDeleted(Client client){
        if (client.isStatus() == false){
            throw new ResourceNotFoundException("ID CLIENT NOT FOUND");
        }
        return client;
    }

    public static void checkClientSearch(Optional<Client> optionalClient){
        if (optionalClient.isEmpty()){
            throw new ResourceNotFoundException("ID CLIENT NOT FOUND");
        }
    }

    public Client findByClientNoConversion(UUID uuid){
        Optional<Client> optionalClient = clientRepository.findById(uuid);
        checkClientSearch(optionalClient);
        Client client = checkClientMarkedDeleted(optionalClient.get());
        return client;
    }
}
