package pl.uberek.ubereats.restaurant;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.uberek.ubereats.enums.RestaurantType;
import pl.uberek.ubereats.user.User;
import pl.uberek.ubereats.menu.Menu;

import javax.persistence.*;
import java.util.Objects;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant extends User {

    private String name;
    @OneToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;
    private double rating;
    @Enumerated(EnumType.STRING)
    private RestaurantType restaurantType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        if (!super.equals(o)) return false;
        Restaurant that = (Restaurant) o;
        return Double.compare(that.rating, rating) == 0 && name.equals(that.name) && menu.equals(that.menu) && restaurantType == that.restaurantType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, menu, rating, restaurantType);
    }

}


