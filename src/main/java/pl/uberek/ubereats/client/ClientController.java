package pl.uberek.ubereats.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uberek.ubereats.client.dtos.ClientAddressDto;
import pl.uberek.ubereats.client.dtos.ClientCreateDto;
import pl.uberek.ubereats.client.dtos.ClientDto;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientCreateDto clientCreateDto){
        ClientDto clientDto = clientService.createClient(clientCreateDto);
        return ResponseEntity.ok(clientDto);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id){return ResponseEntity.ok(clientService.findById(id));}

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> getAllClients(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/clients-premium")
    public ResponseEntity<List<ClientDto>> getAllPremiumClients(){ return ResponseEntity.ok(clientService.findAllPremiumClients()); }

    @GetMapping("/clients-with-address/{id}")
    public ResponseEntity<ClientAddressDto> getClientAndHisAddress(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findClientAndHisAddress(id));
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.ok().body("Client with id " + id + " successfully deleted");
    }

}
