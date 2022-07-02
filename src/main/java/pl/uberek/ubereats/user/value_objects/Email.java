package pl.uberek.ubereats.user.value_objects;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class Email {

    @Getter
    private String email;

    public Email(String email){
        if ( !email.contains("@") ) {
            throw new IllegalArgumentException("Email must contain \" @ \"!");
        }
        if ( email.length() > 45 ){
            throw new IllegalArgumentException("Email must be 45 or less signs!");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email email1)) return false;
        return email.equals(email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

}
