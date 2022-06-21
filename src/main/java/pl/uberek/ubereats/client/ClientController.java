package pl.uberek.ubereats.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable Long id){return ResponseEntity.ok(clientService.findById(id));}

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> getClients(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/clients-premium")
    public ResponseEntity<List<ClientDto>> getPremiumClients(){ return ResponseEntity.ok(clientService.findAllPremiumClients()); }

    @PostMapping("/clients")
    public ResponseEntity<List<ClientDto>> saveClients(@RequestBody List<ClientCreateDto> clientCreateDto){
        List<ClientDto> clients = clientService.save(clientCreateDto);
        return ResponseEntity.ok(clients);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @RequestBody ClientCreateDto clientDto){
        ClientDto client = clientService.update(clientDto, id);
        return ResponseEntity.ok(client);
    }

    @PatchMapping("/clients/{id}/email-change")
    public ResponseEntity<ClientDto> changeClientEmail(@PathVariable Long id, @RequestBody String newEmail){
        ClientDto client = clientService.changeEmail(id, newEmail);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.ok().body("Client with id " + id + "successfully deleted");
    }

}
