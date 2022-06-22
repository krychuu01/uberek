package pl.uberek.ubereats.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService){
        this.dishService = dishService;
    }

    @GetMapping("/dishes")
    public ResponseEntity<List<Dish>> findAll(){
        return ResponseEntity.ok(dishService.findAll());
    }

    @GetMapping("/dishes/{id}")
    public ResponseEntity<Dish> findById(@PathVariable Long id){
        return ResponseEntity.ok(dishService.findById(id));
    }

    @PostMapping("/dishes")
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish){
        return ResponseEntity.ok(dishService.createDish(dish));
    }

    @PatchMapping("/dishes/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long id, @RequestBody DishUpdateDto dish){
        return ResponseEntity.ok(dishService.updateDish(id, dish));
    }

    @DeleteMapping("/dishes/{id}")
    public ResponseEntity<String> deleteDish(@PathVariable Long id){
        String deletedDishName = dishService.findById(id).getName();
        dishService.deleteDish(id);
        return ResponseEntity.ok().body("Dish " + deletedDishName + " deleted successfully");
    }

}
