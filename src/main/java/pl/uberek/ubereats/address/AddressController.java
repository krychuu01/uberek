package pl.uberek.ubereats.address;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uberek.ubereats.address.dtos.AddressDto;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Address>> getAddresses(){
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Address> getAddressById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressDto updateAddress(@PathVariable Long id, @RequestBody AddressDto addressDto){
        return addressService.updateAddress(id, addressDto);
    }

}
