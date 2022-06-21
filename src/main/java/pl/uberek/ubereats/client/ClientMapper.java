package pl.uberek.ubereats.client;

import org.springframework.stereotype.Component;
import pl.uberek.ubereats.client.dtos.ClientCreateDto;
import pl.uberek.ubereats.client.dtos.ClientDto;
import pl.uberek.ubereats.enums.AccountType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {

    public ClientDto fromClientToClientDto(Client client){
        return new ClientDto(client.getFirstName(), client.getLastName(),
                             client.getPhoneNumber(), client.getIsPremium(),
                             client.getEmail(), client.getAddress());
    }

    public Client fromClientCreateDtoToClient(ClientCreateDto clientCreateDto){
        return new Client(clientCreateDto.email(), clientCreateDto.address(),
                AccountType.CLIENT, clientCreateDto.password(),
                clientCreateDto.phoneNumber(), clientCreateDto.firstName(),
                clientCreateDto.lastName(), "not implemented yet",
                clientCreateDto.isPremium(), BigDecimal.ZERO);
    }

    public List<ClientDto> fromClientListToClientDtoList(List<Client> clients){
        List<ClientDto> clientDtoList = new ArrayList<>(clients.size());
        clients.forEach(client -> clientDtoList.add(fromClientToClientDto(client)));
        return clientDtoList;
    }

}
