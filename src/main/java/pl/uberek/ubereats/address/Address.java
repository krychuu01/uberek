package pl.uberek.ubereats.address;

import lombok.*;
import pl.uberek.ubereats.guest.Guest;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "address")
    private Guest guest;
    private String zip_code;
    private String city;
    private String street;
    private String country;

    public Address(Guest guest, String zip_code, String city, String street, String country) {
        this.guest = guest;
        this.zip_code = zip_code;
        this.city = city;
        this.street = street;
        this.country = country;
    }

}
