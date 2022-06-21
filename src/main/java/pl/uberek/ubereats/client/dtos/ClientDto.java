package pl.uberek.ubereats.client.dtos;

import pl.uberek.ubereats.address.Address;

public record ClientDto(String firstName, String lastName,
                        String phoneNumber, Boolean isPremium,
                        String email, Address address) {

}
