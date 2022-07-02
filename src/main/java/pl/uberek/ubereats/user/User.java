package pl.uberek.ubereats.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import pl.uberek.ubereats.address.Address;
import pl.uberek.ubereats.enums.AccountType;
import pl.uberek.ubereats.user.value_objects.Email;
import pl.uberek.ubereats.user.value_objects.PhoneNumber;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@Entity
@Getter
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    @AttributeOverride(name = "email", column = @Column(name = "email"))
    private Email email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    private Address address;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private String password;
    @Embedded
    @AttributeOverride(name = "phoneNumber", column = @Column(name = "phoneNumber"))
    private PhoneNumber phoneNumber;

    public User(Email email, Address address, AccountType accountType, String password, PhoneNumber phoneNumber) {
        this.email = email;
        this.address = address;
        this.accountType = accountType;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

}
