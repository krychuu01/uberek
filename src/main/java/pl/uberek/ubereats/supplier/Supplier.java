package pl.uberek.ubereats.supplier;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.uberek.ubereats.address.Address;
import pl.uberek.ubereats.enums.AccountType;
import pl.uberek.ubereats.user.User;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier extends User {

    private String firstName;
    private String lastName;

    public Supplier(String email, Address address, AccountType accountType, String password, String phoneNumber, String firstName, String lastName) {
        super(email, address, accountType, password, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier)) return false;
        if (!super.equals(o)) return false;
        Supplier supplier = (Supplier) o;
        return firstName.equals(supplier.firstName) && lastName.equals(supplier.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName);
    }

}
