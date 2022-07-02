package pl.uberek.ubereats.supplier;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.uberek.ubereats.address.Address;
import pl.uberek.ubereats.enums.AccountType;
import pl.uberek.ubereats.user.User;
import pl.uberek.ubereats.user.value_objects.Email;
import pl.uberek.ubereats.user.value_objects.PhoneNumber;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier extends User {

    private String firstName;
    private String lastName;

    public Supplier(Email email, Address address, AccountType accountType, String password,
                    PhoneNumber phoneNumber, String firstName, String lastName) {
        super(email, address, accountType, password, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
