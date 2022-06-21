package pl.uberek.ubereats.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uberek.ubereats.address.dtos.AddressDto;

import java.util.List;

@RestController
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<Address>> getAddresses(){
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PatchMapping("/addresses/{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable Long id, @RequestBody AddressDto addressDto){
        return ResponseEntity.ok(addressService.updateAddress(id, addressDto));
    }

}
