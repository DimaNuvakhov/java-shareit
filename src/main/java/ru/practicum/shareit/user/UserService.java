package ru.practicum.shareit.user;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    UserDto add(UserDto user);

    UserDto update(UserDto user);

    Optional<User> getById(Integer id);

    Collection<UserDto> getAll();

    void deleteById(Integer id);

    UserDto patch(Integer userId, UserDto user);
}
