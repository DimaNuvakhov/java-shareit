package ru.practicum.shareit.user;

import java.util.List;

public interface UserService {

    UserDto add(User user);

    UserDto update(User user);

    UserDto getById(Integer id);

    List<UserDto> getAll();

    Boolean deleteById(Integer id);

    UserDto patch(Integer userId, User user);
}
