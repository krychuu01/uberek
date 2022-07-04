package pl.uberek.ubereats.restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.save(restaurant);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Restaurant getById(@PathVariable Long id){
        return restaurantService.getById(id);
    }

}
