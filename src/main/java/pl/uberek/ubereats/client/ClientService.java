package pl.uberek.ubereats.client;

import org.springframework.stereotype.Service;
import pl.uberek.ubereats.client.dtos.ClientAddressDto;
import pl.uberek.ubereats.client.dtos.ClientCreateDto;
import pl.uberek.ubereats.client.dtos.ClientDto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static pl.uberek.ubereats.client.ClientMapper.*;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final EntityManager em;

    public ClientService(ClientRepository clientRepository, EntityManager em){
        this.clientRepository = clientRepository;
        this.em = em;
    }

    public ClientDto createClient(ClientCreateDto clientCreateDto) {
        Client client = ClientMapper.fromClientCreateDtoToClient(clientCreateDto);
        if(client.getAddress() == null) throw new NullPointerException("Address mustn't be null");
        clientRepository.save(client);
        return fromClientToClientDto(client);
    }

    public Client findClientById(Long id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("client with id: " + id + " not found"));
    }

    public ClientDto findById(Long id){
        Client client = findClientById(id);
        return fromClientToClientDto(client);
    }

    public List<ClientDto> findAll() {
        List<Client> clients = clientRepository.findAll();
        return fromClientListToClientDtoList(clients);
    }

    public List<ClientDto> findAllPremiumClients(){
        List<Client> clients = clientRepository.findByIsPremiumTrue();
        return fromClientListToClientDtoList(clients);
    }

    public ClientAddressDto findClientAndHisAddress(Long id){
        var client = clientRepository.findFirstNameAndLastNameAndAddressById(id);

        return client.map(ClientMapper::fromClientToClientAddressDto)
                .orElseThrow( () -> new NoSuchElementException("client with id: " + id + " not found") );
    }

    public void deleteClient(Long id) {
        Client client = findClientById(id);
        clientRepository.delete(client);
    }

}
