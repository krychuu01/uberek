package pl.uberek.ubereats.menu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.uberek.ubereats.dish.Dish;
import pl.uberek.ubereats.restaurant.Restaurant;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
//    private List<Dish> dishList;
    @OneToOne(mappedBy = "menu")
    private Restaurant restaurant;

}
