package pl.uberek.ubereats.address;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.uberek.ubereats.address.dtos.AddressDto;

import java.util.List;
import java.util.NoSuchElementException;

import static pl.uberek.ubereats.address.AddressMapper.fromAddressToAddressDto;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("address with id " + id + " not found"));
    }

    public AddressDto updateAddress(Long id, AddressDto addressDto) {
        Address addressToUpdate = findById(id);

        if (addressDto.city() != null) addressToUpdate.setCity(addressDto.city());
        if (addressDto.country() != null) addressToUpdate.setCountry(addressDto.country());
        if (addressDto.street() != null) addressToUpdate.setStreet(addressDto.street());
        if (addressDto.zip_code() != null) addressToUpdate.setZip_code(addressDto.zip_code());

        addressRepository.save(addressToUpdate);
        return fromAddressToAddressDto(addressToUpdate);
    }

}
