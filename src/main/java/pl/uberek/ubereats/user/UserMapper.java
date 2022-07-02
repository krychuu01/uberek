package pl.uberek.ubereats.user;

import org.springframework.stereotype.Component;
import pl.uberek.ubereats.user.dtos.UserDto;
import pl.uberek.ubereats.user.value_objects.Email;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserDto fromUserToUserDto(User user){
        return new UserDto(new Email(user.getEmail().getEmail()), user.getAddress(), user.getAccountType(),
                user.getPassword(), user.getPhoneNumber());
    }
    public List<UserDto> fromUserListToUserDtoList(List<User> users){
        List<UserDto> userDtoList = new ArrayList<>(users.size());
        users.forEach(user -> userDtoList.add(fromUserToUserDto(user)));
        return userDtoList;
    }

}
