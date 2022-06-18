package pl.uberek.ubereats.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.uberek.ubereats.address.Address;
import pl.uberek.ubereats.enums.AccountType;
import pl.uberek.ubereats.guest.Guest;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client extends Guest {

    private String firstName;
    private String lastName;
    private String cardNumber;
    private Boolean isPremium = Boolean.FALSE;
    private BigDecimal walletBalance;

    public Client(String email, Address address, AccountType accountType, String password, String phoneNumber, String firstName, String lastName, String cardNumber, Boolean isPremium, BigDecimal walletBalance) {
        super(email, address, accountType, password, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
        this.isPremium = isPremium;
        this.walletBalance = walletBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return firstName.equals(client.firstName) && lastName.equals(client.lastName) && cardNumber.equals(client.cardNumber) && isPremium.equals(client.isPremium) && walletBalance.equals(client.walletBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, cardNumber, isPremium, walletBalance);
    }

}
