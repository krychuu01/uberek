package pl.uberek.ubereats.user.dtos;

import org.springframework.stereotype.Component;
import pl.uberek.ubereats.user.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public static UserDto fromUserToUserDto(User user){
        return new UserDto.UserDtoBuilder()
                .email(user.getEmail())
                .address(user.getAddress())
                .accountType(user.getAccountType())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }

    public static List<UserDto> fromUserListToUserDtoList(List<User> users){
        return users.stream()
                .map(UserMapper::fromUserToUserDto)
                .collect(Collectors.toList());
    }

}
