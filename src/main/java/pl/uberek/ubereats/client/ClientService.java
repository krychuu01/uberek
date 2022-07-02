package pl.uberek.ubereats.client;

import org.springframework.stereotype.Service;
import pl.uberek.ubereats.client.dtos.ClientAddressDto;
import pl.uberek.ubereats.client.dtos.ClientCreateDto;
import pl.uberek.ubereats.client.dtos.ClientDto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.NoSuchElementException;

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
        Query q = em.createQuery("SELECT new pl.uberek.ubereats.client.dtos.ClientAddressDto(c.firstName, c.lastName, a.city, a.street)" +
                " FROM Client AS c " +
                " INNER JOIN pl.uberek.ubereats.address.Address AS a ON c.address = a.id " +
                " WHERE c.id = ?1 ");
        q.setParameter(1, 1L);
        return (ClientAddressDto) q.getSingleResult();
    }

    public void deleteClient(Long id) {
        Client client = findClientById(id);
        clientRepository.delete(client);
    }

}
