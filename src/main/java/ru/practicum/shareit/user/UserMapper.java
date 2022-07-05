package ru.practicum.shareit.user;

import java.util.HashMap;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public static HashMap<Integer, UserDto> toUserDtoMap(HashMap<Integer, User> users) {
        HashMap<Integer, UserDto> userDtos = new HashMap<>();
        for(User user : users.values()) {
            userDtos.put(user.getId(), toUserDto(user));
        }
        return userDtos;
    }
}
