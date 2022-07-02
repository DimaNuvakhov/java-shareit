package ru.practicum.shareit.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public static List<UserDto> toUserDtoList(HashMap<Integer, User> users) {
        List<UserDto> usersDto = new ArrayList<>();
        for(User user : users.values()) {
            usersDto.add(toUserDto(user));
        }
        return usersDto;
    }
}
