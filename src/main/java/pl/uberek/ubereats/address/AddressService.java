package pl.uberek.ubereats.address;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.uberek.ubereats.address.dtos.AddressDto;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Autowired
    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper){
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("address with id " + id + " not found"));
    }

    public Address createAddress(AddressDto addressDto) {
        Address address = addressMapper.fromAddressCreateDtoToAddress(addressDto);
        return addressRepository.save(address);
    }

    public AddressDto updateAddress(Long id, AddressDto addressDto) {
        Address address = findById(id);

        if (addressDto.city() != null) address.setCity(addressDto.city());
        if (addressDto.country() != null) address.setCountry(addressDto.country());
        if (addressDto.street() != null) address.setStreet(addressDto.street());
        if (addressDto.zip_code() != null) address.setZip_code(addressDto.zip_code());

        addressRepository.save(address);
        return addressMapper.fromAddressToAddressDto(address);
    }

}
