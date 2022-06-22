package pl.uberek.ubereats.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository){
        this.dishRepository = dishRepository;
    }

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public Dish findById(Long id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Element with id: " + id + " not found"));
    }

    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public Dish updateDish(Long id, DishUpdateDto dishUpdateDto){
        Dish dishToUpdate = findById(id);

        if(dishUpdateDto.name() != null) dishToUpdate.setName(dishUpdateDto.name());
        if(dishUpdateDto.description() != null) dishToUpdate.setDescription(dishUpdateDto.description());
        if(dishUpdateDto.price() != null) dishToUpdate.setPrice(dishUpdateDto.price());
        if(dishUpdateDto.weight() != null) dishToUpdate.setWeight(dishUpdateDto.weight());

        return dishRepository.save(dishToUpdate);
    }

    public void deleteDish(Long id) {
        Dish dishToDelete = findById(id);
        dishRepository.delete(dishToDelete);
    }

}
