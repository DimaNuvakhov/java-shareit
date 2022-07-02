package ru.practicum.shareit.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.error.EmailAlreadyExistsException;
import ru.practicum.shareit.error.InvalidEmailException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userStorage;

    @Autowired
    public UserServiceImpl(UserRepository userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public UserDto add(User user) {
        if (user.getEmail() == null) {
            throw new InvalidEmailException("Электронная почта не указана");
        }
        for (UserDto userDto : userStorage.getAll()) {
            if (user.getEmail().equals(userDto.getEmail())) {
                throw new EmailAlreadyExistsException("Пользователь с такой почтой уже есть в базе данных");
            }
        }
        if (!user.getEmail().contains("@")) {
            throw new InvalidEmailException("Указан некорректный адрес электронной почты");
        }
        return userStorage.add(user);
    }

    @Override
    public UserDto update(User user) {
        for (UserDto userDto : userStorage.getAll()) {
            if (user.getEmail().equals(userDto.getEmail())) {
                throw new EmailAlreadyExistsException("Пользователь с такой почтой уже есть в базе данных");
            }
        }
        if (!user.getEmail().contains("@")) {
            throw new InvalidEmailException("Указан некорректный адрес электронной почты");
        }
        return userStorage.update(user);
    }

    @Override
    public UserDto getById(Integer id) {
        return userStorage.getById(id);
    }

    @Override
    public List<UserDto> getAll() {
        return userStorage.getAll();
    }

    @Override
    public Boolean deleteById(Integer id) {
        return userStorage.deleteById(id);
    }
}
