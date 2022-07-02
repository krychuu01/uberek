package pl.uberek.ubereats.client.dtos;

import pl.uberek.ubereats.address.Address;
import pl.uberek.ubereats.user.value_objects.Email;

public record ClientDto(String firstName, String lastName,
                        String phoneNumber, Boolean isPremium,
                        Email email, Address address) {

}
