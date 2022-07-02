package pl.uberek.ubereats.user.dtos;

import lombok.Builder;
import pl.uberek.ubereats.address.Address;
import pl.uberek.ubereats.enums.AccountType;
import pl.uberek.ubereats.user.value_objects.Email;
import pl.uberek.ubereats.user.value_objects.PhoneNumber;

public record UserDto(Email email, Address address,
                      AccountType accountType, String password,
                      PhoneNumber phoneNumber) {
    @Builder public UserDto {}
}
