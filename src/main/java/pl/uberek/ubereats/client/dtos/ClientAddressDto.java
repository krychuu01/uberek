package pl.uberek.ubereats.client.dtos;

import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
public record ClientAddressDto (String firstName, String lastName, String city, String street){

    @Builder public ClientAddressDto {}

}
