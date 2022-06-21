package pl.uberek.ubereats.client.dtos;

public record ClientUpdateDto(String firstName, String lastName, String email,
                              String password, String phoneNumber, Boolean isPremium) {
}
