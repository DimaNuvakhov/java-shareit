package ru.practicum.shareit.user;

import java.util.List;

public interface UserRepository {

    UserDto add(User user);

    UserDto update(User user);

    UserDto getById(Integer id);

    List<UserDto> getAll();

    UserDto patch(Integer userId, User user);

    Boolean deleteById(Integer id);
}
