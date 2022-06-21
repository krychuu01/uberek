package pl.uberek.ubereats.menu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.uberek.ubereats.dish.Dish;
import pl.uberek.ubereats.restaurant.Restaurant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany
    private List<Dish> dishList = new ArrayList<>();
    @OneToOne(mappedBy = "menu")
    private Restaurant restaurant;

}
