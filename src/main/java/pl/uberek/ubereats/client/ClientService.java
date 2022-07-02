package pl.uberek.ubereats.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.uberek.ubereats.client.dtos.ClientCreateDto;
import pl.uberek.ubereats.client.dtos.ClientDto;

import java.util.List;
import java.util.NoSuchElementException;

import static pl.uberek.ubereats.client.ClientMapper.fromClientListToClientDtoList;
import static pl.uberek.ubereats.client.ClientMapper.fromClientToClientDto;

@Component
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
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

    public void deleteClient(Long id) {
        Client client = findClientById(id);
        clientRepository.delete(client);
    }

}
