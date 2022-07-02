package pl.uberek.ubereats.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uberek.ubereats.client.dtos.ClientAddressDto;
import pl.uberek.ubereats.client.dtos.ClientCreateDto;
import pl.uberek.ubereats.client.dtos.ClientDto;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto createClient(@RequestBody ClientCreateDto clientCreateDto){
        return clientService.createClient(clientCreateDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto getClientById(@PathVariable Long id){return clientService.findById(id);}

    @GetMapping("")
    public ResponseEntity<List<ClientDto>> getAllClients(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/premium")
    public ResponseEntity<List<ClientDto>> getAllPremiumClients(){ return ResponseEntity.ok(clientService.findAllPremiumClients()); }

    @GetMapping("/with-address/{id}")
    public ResponseEntity<Object> getClientAndHisAddress(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findClientAndHisAddress(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.ok().body("Client with id " + id + " successfully deleted");
    }

}
