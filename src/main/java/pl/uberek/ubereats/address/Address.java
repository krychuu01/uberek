package pl.uberek.ubereats.address;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import pl.uberek.ubereats.user.User;

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
    @JsonBackReference
    private User user;
    private String zip_code;
    private String city;
    private String street;
    private String country;

    public Address(String zip_code, String city, String street, String country) {
        this.zip_code = zip_code;
        this.city = city;
        this.street = street;
        this.country = country;
    }

}
