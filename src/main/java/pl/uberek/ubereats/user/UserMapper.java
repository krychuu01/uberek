package pl.uberek.ubereats.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserDto fromUserToUserDto(User user){
        return new UserDto(user.getEmail(), user.getAddress(), user.getAccountType(),
                user.getPassword(), user.getPhoneNumber());
    }
    public List<UserDto> fromUserListToUserDtoList(List<User> users){
        List<UserDto> userDtoList = new ArrayList<>(users.size());
        users.forEach(user -> userDtoList.add(fromUserToUserDto(user)));
        return userDtoList;
    }

}
