package pl.uberek.ubereats.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uberek.ubereats.user.dtos.UserDto;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

}
