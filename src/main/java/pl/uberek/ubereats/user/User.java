package pl.uberek.ubereats.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.uberek.ubereats.address.Address;
import pl.uberek.ubereats.enums.AccountType;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private String password;
    private String phoneNumber;

    public User(String email, Address address, AccountType accountType, String password, String phoneNumber) {
        this.email = email;
        this.address = address;
        this.accountType = accountType;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

}
