package pl.uberek.ubereats.guest;

import lombok.*;
import pl.uberek.ubereats.address.Address;
import pl.uberek.ubereats.enums.AccountType;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@MappedSuperclass
public abstract class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @Enumerated(EnumType.STRING)
    private AccountType accountType = AccountType.GUEST;
    private String password;
    private String phoneNumber;

    public Guest(String email, Address address, AccountType accountType, String password, String phoneNumber) {
        this.email = email;
        this.address = address;
        this.accountType = accountType;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return id.equals(guest.id) && email.equals(guest.email) && address.equals(guest.address) && accountType == guest.accountType && password.equals(guest.password) && phoneNumber.equals(guest.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, address, accountType, password, phoneNumber);
    }

}
