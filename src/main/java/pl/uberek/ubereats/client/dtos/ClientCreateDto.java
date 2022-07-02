package pl.uberek.ubereats.client.dtos;

import lombok.Builder;
import pl.uberek.ubereats.address.Address;
import pl.uberek.ubereats.user.value_objects.Email;
import pl.uberek.ubereats.user.value_objects.PhoneNumber;

public record ClientCreateDto(String firstName, String lastName, Email email,
                              String password, PhoneNumber phoneNumber, Boolean isPremium,
                              Address address) {
    @Builder public ClientCreateDto {}

}
