package br.com.udemy.Spring.FullStack.services;

import br.com.udemy.Spring.FullStack.domain.*;
import br.com.udemy.Spring.FullStack.dto.ClientDto;
import br.com.udemy.Spring.FullStack.exception.ResourceNotFoundException;
import br.com.udemy.Spring.FullStack.factory.*;
import br.com.udemy.Spring.FullStack.form.atualizar.ClientRefresh;
import br.com.udemy.Spring.FullStack.form.salvar.ClientForm;
import br.com.udemy.Spring.FullStack.form.salvar.ClientFormFull;
import br.com.udemy.Spring.FullStack.repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Regra de Negócio Centralizado: Client
 */
@Service
public class ClientService {

    // Váriaveis de Repository
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TelephoneRepository telephoneRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AddressRepository addressRepository;

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

    /**
     * Salva um cliente completo
     * @param clientFormFull - Recebe o cliente completo
     */
    public void saveClientFull(ClientFormFull clientFormFull){
        State state = convertClientFormFullInState(clientFormFull);
        City city = convertClientFormFullInCity(clientFormFull,state);
        Address address = convertClientFormFullInAddress(clientFormFull,city);
        Client client = ClientBusinessRule.convertClientFormInClient(clientFormFull);
        List<Telephone> listTelephone = TelephoneBusinessRule.convertClientFormFullInTelephone(clientFormFull);
        client.setListTelephone(listTelephone);
        for(Telephone telephone : listTelephone){
            telephone.setClient(client);
        }
        address.setClient(client);
        client.addListaEndereco(address);
        clientRepository.save(client);
        telephoneRepository.saveAll(listTelephone);
    }

    /**
     * Converte um clientForm em State
     * @param clientFormFull - Recebe o cliente completo
     * @return - retorna o state criado
     */
    private State convertClientFormFullInState(ClientFormFull clientFormFull) {
        Optional<State> optionalState = stateRepository.findByUf(clientFormFull.getUf());
        if (optionalState.isEmpty()){
            throw new RuntimeException("State Not Found");
        }
        return optionalState.get();
    }

    /**
     * Converte um ClientFormFull em City
     * @param clientFormFull - Recebe o cliente completo
     * @param state - Estado pesquisado no Banco de Dados
     * @return - Retorna a Cidade criada
     */
    private City convertClientFormFullInCity(ClientFormFull clientFormFull, State state){
        City city = new City(clientFormFull.getCity(), state);
        state.addCidade(city);
        cityRepository.save(city);
        return city;
    }

    /**
     * Converte ClientForm em Address
     * @param clientFormFull - Recebe o cliente completo
     * @param city - Recebe a cidade criada
     * @return - retorna o address criado
     */
    public Address convertClientFormFullInAddress(ClientFormFull clientFormFull, City city){
        Address address = new Address(clientFormFull.getAddress(), clientFormFull.getNumber(),
                clientFormFull.getDistrict(), clientFormFull.getCep(), city);
        address.setCity(city);
        addressRepository.save(address);
        return address;
    }
}
