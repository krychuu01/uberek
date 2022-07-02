package pl.uberek.ubereats.user.dtos;

import pl.uberek.ubereats.address.Address;
import pl.uberek.ubereats.enums.AccountType;
import pl.uberek.ubereats.user.value_objects.Email;

public record UserDto(Email email, Address address,
                      AccountType accountType, String password,
                      String phoneNumber) {
}
