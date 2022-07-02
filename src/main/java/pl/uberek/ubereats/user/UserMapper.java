package pl.uberek.ubereats.user;

import pl.uberek.ubereats.user.dtos.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto fromUserToUserDto(User user){
        return UserDto.builder()
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
