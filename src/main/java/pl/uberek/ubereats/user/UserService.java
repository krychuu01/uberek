package pl.uberek.ubereats.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.uberek.ubereats.user.dtos.UserDto;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("user with id: " + id + " not found"));
    }

    public UserDto getUserById(Long id){
        User user = findUserById(id);
        return userMapper.fromUserToUserDto(user);
    }

    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.fromUserListToUserDtoList(users);
    }

}
