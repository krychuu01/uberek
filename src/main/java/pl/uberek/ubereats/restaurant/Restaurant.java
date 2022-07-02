package pl.uberek.ubereats.restaurant;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.uberek.ubereats.address.Address;
import pl.uberek.ubereats.dish.Dish;
import pl.uberek.ubereats.enums.AccountType;
import pl.uberek.ubereats.enums.RestaurantType;
import pl.uberek.ubereats.user.User;
import pl.uberek.ubereats.user.value_objects.Email;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant extends User {

    private String name;
    private Double rating;
    @Enumerated(EnumType.STRING)
    private RestaurantType restaurantType;
    @OneToMany(mappedBy = "id")
    @JsonManagedReference
    private Set<Dish> dishes;

    public Restaurant(Email email, Address address, AccountType accountType, String password, String phoneNumber, String name, Double rating, RestaurantType restaurantType, Set<Dish> dishes) {
        super(email, address, accountType, password, phoneNumber);
        this.name = name;
        this.rating = rating;
        this.restaurantType = restaurantType;
        this.dishes = dishes;
    }

}


