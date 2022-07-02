package pl.uberek.ubereats.client.dtos;

import lombok.Builder;

public record ClientAddressDto (String firstName, String lastName, String city, String street){

    @Builder public ClientAddressDto {}

}
