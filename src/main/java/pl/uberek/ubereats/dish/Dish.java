package pl.uberek.ubereats.dish;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;
import pl.uberek.ubereats.menu.Menu;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
    private String name;
    private BigDecimal price;
    @Nullable private String description;
    @Nullable private int weight;



}
