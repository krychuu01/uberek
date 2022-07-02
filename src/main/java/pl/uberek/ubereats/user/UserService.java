package pl.uberek.ubereats.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.uberek.ubereats.user.dtos.UserDto;
import pl.uberek.ubereats.user.dtos.UserMapper;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("user with id: " + id + " not found"));
    }

    public UserDto getUserById(Long id){
        var user = findUserById(id);
        return UserMapper.fromUserToUserDto(user);
    }

    public List<UserDto> getUsers() {
        var users = userRepository.findAll();
        return UserMapper.fromUserListToUserDtoList(users);
    }

}
