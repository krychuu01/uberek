package pl.uberek.ubereats.user.value_objects;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class PhoneNumber {

    @Getter
    private String number;

    public PhoneNumber(String number) {
        if( number.length() != 9 ){
            throw new IllegalArgumentException("Phone number must be 9 digits!");
        }
        if( !number.matches("[0-9]+") ){
            throw new IllegalArgumentException("Phone number must only contain digits!");
        }
        this.number = number;
    }

    @Override
    public String toString() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber that)) return false;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
