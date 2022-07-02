package pl.uberek.ubereats.client;

import org.springframework.stereotype.Component;
import pl.uberek.ubereats.client.dtos.ClientAddressDto;
import pl.uberek.ubereats.client.dtos.ClientCreateDto;
import pl.uberek.ubereats.client.dtos.ClientDto;
import pl.uberek.ubereats.enums.AccountType;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public static ClientDto fromClientToClientDto(Client client){
        return ClientDto.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .phoneNumber(client.getPhoneNumber())
                .isPremium(client.getIsPremium())
                .email(client.getEmail())
                .build();
    }

    public static Client fromClientCreateDtoToClient(ClientCreateDto clientCreateDto){
        return Client.builder()
                .email(clientCreateDto.email())
                .address(clientCreateDto.address())
                .accountType(AccountType.CLIENT)
                .password(clientCreateDto.password())
                .phoneNumber(clientCreateDto.phoneNumber())
                .firstName(clientCreateDto.firstName())
                .lastName(clientCreateDto.lastName())
                .isPremium(clientCreateDto.isPremium())
                .build();
    }

    public static ClientAddressDto fromClientToClientAddressDto(Client client){
        return ClientAddressDto.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .city(client.getAddress().getCity())
                .street(client.getAddress().getStreet())
                .build();
    }

    public static List<ClientDto> fromClientListToClientDtoList(List<Client> clients){
        return clients.stream()
                .map(ClientMapper::fromClientToClientDto)
                .collect(Collectors.toList());
    }

}
