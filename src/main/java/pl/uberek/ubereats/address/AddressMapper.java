package pl.uberek.ubereats.address;

import org.springframework.stereotype.Component;
import pl.uberek.ubereats.address.dtos.AddressDto;

@Component
public class AddressMapper {

    public AddressDto fromAddressToAddressDto(Address address){
        return new AddressDto(address.getZip_code(), address.getCity(),
                                    address.getStreet(), address.getCountry());
    }

}
