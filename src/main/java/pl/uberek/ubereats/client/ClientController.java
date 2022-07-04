package pl.uberek.ubereats.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.uberek.ubereats.client.dtos.ClientAddressDto;
import pl.uberek.ubereats.client.dtos.ClientCreateDto;
import pl.uberek.ubereats.client.dtos.ClientDto;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto createClient(@RequestBody ClientCreateDto clientCreateDto){
        return clientService.createClient(clientCreateDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto getClientById(@PathVariable Long id){return clientService.findById(id);}

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> getAllClients(){
        return clientService.findAll();
    }

    @GetMapping("/premium")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> getAllPremiumClients(){ return clientService.findAllPremiumClients(); }

    @GetMapping("/with-address/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientAddressDto getClientAndHisAddress(@PathVariable Long id){
        return clientService.findClientAndHisAddress(id);
    }

    @GetMapping("/with-address")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientAddressDto> getClientsAndTheirAdresses(){
        return clientService.findClientsAndTheirAdresses();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return "Client with id " + id + " successfully deleted";
    }

}
