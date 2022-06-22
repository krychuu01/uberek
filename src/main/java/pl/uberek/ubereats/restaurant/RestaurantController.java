package pl.uberek.ubereats.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        return ResponseEntity.ok(restaurantService.getAll());
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> getById(@PathVariable Long id){
        return ResponseEntity.ok(restaurantService.getById(id));
    }

    @PostMapping("/restaurants")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant){
        return ResponseEntity.ok(restaurantService.save(restaurant));
    }

}
