package pl.uberek.ubereats.client.dtos;

import pl.uberek.ubereats.address.Address;

public record ClientCreateDto(String firstName, String lastName, String email,
                              String password, String phoneNumber, Boolean isPremium,
                              Address address) {

}
