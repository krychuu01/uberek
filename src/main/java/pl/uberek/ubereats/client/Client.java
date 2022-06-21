package pl.uberek.ubereats.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.uberek.ubereats.address.Address;
import pl.uberek.ubereats.enums.AccountType;
import pl.uberek.ubereats.user.User;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client extends User {

    private String firstName;
    private String lastName;
    private String cardNumber;
    private Boolean isPremium = Boolean.FALSE;
    private BigDecimal walletBalance;

    public Client(String email, Address address, AccountType accountType, String password, String phoneNumber, String firstName, String lastName, String cardNumber, Boolean isPremium, BigDecimal walletBalance) {
        super(email, address, accountType, password, phoneNumber);
        setAccountType(AccountType.CLIENT);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
        this.isPremium = isPremium;
        this.walletBalance = walletBalance;
    }

}






