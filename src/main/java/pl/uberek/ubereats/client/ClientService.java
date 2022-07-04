package pl.uberek.ubereats.client;

import org.springframework.stereotype.Service;
import pl.uberek.ubereats.client.dtos.ClientAddressDto;
import pl.uberek.ubereats.client.dtos.ClientCreateDto;
import pl.uberek.ubereats.client.dtos.ClientDto;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.NoSuchElementException;

import static pl.uberek.ubereats.client.ClientMapper.*;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final EntityManager entityManager;

    public ClientService(ClientRepository clientRepository, EntityManager entityManager){
        this.clientRepository = clientRepository;
        this.entityManager = entityManager;
    }

    public ClientDto createClient(ClientCreateDto clientCreateDto) {
        Client client = fromClientCreateDtoToClient(clientCreateDto);
        if(client.getAddress() == null) throw new NullPointerException("Address mustn't be null");
        clientRepository.save(client);
        return fromClientToClientDto(client);
    }

    public List<ClientDto> findAll() {
        var clients = clientRepository.findAll();
        return fromClientListToClientDtoList(clients);
    }

    private Client findClientById(Long id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("client with id: " + id + " not found"));
    }

    public ClientDto findById(Long id){
        Client client = findClientById(id);
        return fromClientToClientDto(client);
    }

    public List<ClientDto> findAllPremiumClients(){
        var clients = clientRepository.findByIsPremiumTrue();
        return fromClientListToClientDtoList(clients);
    }

    public ClientAddressDto findClientAndHisAddress(Long id){
        var client = findClientById(id);
        return fromClientToClientAddressDto(client);
    }

    public List<ClientAddressDto> findClientsAndTheirAdresses(){
        var query = entityManager.createQuery(" SELECT new pl.uberek.ubereats.client.dtos" +
                ".ClientAddressDto(c.id, c.firstName, c.lastName, c.address.city, c.address.street)" +
                " FROM Client c", ClientAddressDto.class);
        return query.getResultList();
    }

    public void deleteClient(Long id) {
        var client = findClientById(id);
        clientRepository.delete(client);
    }
    
}
