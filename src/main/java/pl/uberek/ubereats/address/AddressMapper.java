package pl.uberek.ubereats.address;

import pl.uberek.ubereats.address.dtos.AddressDto;

public class AddressMapper {

    public static AddressDto fromAddressToAddressDto(Address address){
        return new AddressDto(address.getZip_code(), address.getCity(),
                                    address.getStreet(), address.getCountry());
    }

}
