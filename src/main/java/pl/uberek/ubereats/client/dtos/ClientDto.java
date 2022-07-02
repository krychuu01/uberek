package pl.uberek.ubereats.client.dtos;

import lombok.Builder;
import pl.uberek.ubereats.user.value_objects.Email;
import pl.uberek.ubereats.user.value_objects.PhoneNumber;

public record ClientDto(String firstName, String lastName,
                        PhoneNumber phoneNumber, Boolean isPremium,
                        Email email) {

    @Builder public ClientDto {}

}
