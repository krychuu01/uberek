package pl.uberek.ubereats.user;

import pl.uberek.ubereats.address.Address;
import pl.uberek.ubereats.enums.AccountType;

public record UserDto(String email, Address address,
                      AccountType accountType, String password,
                      String phoneNumber) {
}
