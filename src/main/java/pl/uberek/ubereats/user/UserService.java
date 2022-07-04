package pl.uberek.ubereats.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.uberek.ubereats.user.dtos.UserDto;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService {

    public static final int PAGE_SIZE = 2;
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

    public List<UserDto> getUsersPage(int page){
        if (page <= 0) page = 0;
        var users = userRepository.findAll(PageRequest.of(page, PAGE_SIZE));
        return users.stream()
                .map(UserMapper::fromUserToUserDto)
                .collect(Collectors.toList());
    }

}
