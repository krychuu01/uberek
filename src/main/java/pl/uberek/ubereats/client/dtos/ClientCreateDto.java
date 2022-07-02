package pl.uberek.ubereats.client.dtos;

import pl.uberek.ubereats.address.Address;
import pl.uberek.ubereats.user.value_objects.Email;

public record ClientCreateDto(String firstName, String lastName, Email email,
                              String password, String phoneNumber, Boolean isPremium,
                              Address address) {

}
