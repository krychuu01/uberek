package pl.uberek.ubereats.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;

@Setter
@Getter
@AllArgsConstructor
@Component
@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client findById(@PathVariable Long id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("guest with id: " + id + " not found"));
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public List<Client> saveAll(List<Client> clients) {
        return clientRepository.saveAll(clients);
    }
}
