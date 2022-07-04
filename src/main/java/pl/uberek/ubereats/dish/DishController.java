package pl.uberek.ubereats.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService){
        this.dishService = dishService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Dish createDish(@RequestBody Dish dish){
        return dishService.createDish(dish);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Dish> findAll(){
        return dishService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dish findById(@PathVariable Long id){
        return dishService.findById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dish updateDish(@PathVariable Long id, @RequestBody DishUpdateDto dish){
        return dishService.updateDish(id, dish);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteDish(@PathVariable Long id){
        dishService.deleteDish(id);
        return "Dish with id: " + id + " deleted successfully";
    }

}
