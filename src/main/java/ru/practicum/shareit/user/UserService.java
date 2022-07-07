package ru.practicum.shareit.user;

import java.util.Collection;

public interface UserService {

    UserDto add(UserDto userDto);

    UserDto update(UserDto userDto);

    UserDto getById(Integer id);

    Collection<UserDto> getAll();

    Boolean deleteById(Integer id);

    UserDto patch(Integer userId, UserDto userDto);
}
