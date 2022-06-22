package pl.uberek.ubereats.dish;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import pl.uberek.ubereats.restaurant.Restaurant;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;
    private String name;
    private BigDecimal price;
    @Nullable private String description;
    @Nullable private Integer weight;

    public Dish(Restaurant restaurant, String name, BigDecimal price, @Nullable String description, @Nullable Integer weight) {
        this.restaurant = restaurant;
        this.name = name;
        this.price = price;
        this.description = description;
        this.weight = weight;
    }

}
