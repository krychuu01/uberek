package pl.uberek.ubereats.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.uberek.ubereats.client.dtos.ClientCreateDto;
import pl.uberek.ubereats.client.dtos.ClientDto;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper){
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

//    public List<ClientDto> createClients(List<ClientCreateDto> clientCreateDtoList){
//        List<Client> listOfClients = new ArrayList<>(clientCreateDtoList.size());
//
//        for (ClientCreateDto clientcreateDto : clientCreateDtoList) {
//            Client mappedClient = clientMapper.fromClientCreateDtoToClient(clientcreateDto);
//            clientRepository.save(mappedClient);
//            listOfClients.add(mappedClient);
//        }
//
//        return clientMapper.fromClientListToClientDtoList(listOfClients);
//    }

    public ClientDto createClient(ClientCreateDto clientCreateDto) {
        Client client = clientMapper.fromClientCreateDtoToClient(clientCreateDto);
        clientRepository.save(client);
        return clientMapper.fromClientToClientDto(client);
    }

    public Client findClientById(Long id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("guest with id: " + id + " not found"));
    }

    public ClientDto findById(Long id){
        Client client = findClientById(id);
        return clientMapper.fromClientToClientDto(client);
    }

    public List<ClientDto> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clientMapper.fromClientListToClientDtoList(clients);
    }

    public List<ClientDto> findAllPremiumClients(){
        List<Client> clients = clientRepository.findByIsPremiumTrue();
        return clientMapper.fromClientListToClientDtoList(clients);
    }

    public void deleteClient(Long id) {
        Client client = findClientById(id);
        clientRepository.delete(client);
    }

}
