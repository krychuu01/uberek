package pl.uberek.ubereats.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id){
        return clientService.findById(id);
    }

    @GetMapping("")
    public List<Client> getClients(){
        return clientService.findAll();
    }

    @PostMapping("")
    public List<Client> saveClients(@RequestBody List<Client> clients){
        return clientService.saveAll(clients);
    }

}
