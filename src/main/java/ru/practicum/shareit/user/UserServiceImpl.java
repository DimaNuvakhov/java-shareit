package ru.practicum.shareit.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.error.EmailAlreadyExistsException;
import ru.practicum.shareit.error.InvalidEmailException;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userStorage) {
        this.userRepository = userStorage;
    }

    @Override
    public UserDto add(UserDto user) {
        if (user.getEmail() == null) {
            throw new InvalidEmailException("Электронная почта не указана");
        }
        for (User foundedUser : userRepository.findAll()) {
            if (user.getEmail().equals(foundedUser.getEmail())) {
                throw new EmailAlreadyExistsException("Пользователь с такой почтой уже есть в базе данных");
            }
        }
        if (!user.getEmail().contains("@")) {
            throw new InvalidEmailException("Указан некорректный адрес электронной почты");
        }
        return UserMapper.toUserDto(userRepository.save(UserMapper.toUser(user)));
    }

    @Override
    public UserDto update(UserDto user) {
        for (User foundedUser : userRepository.findAll()) {
            if (user.getEmail().equals(foundedUser.getEmail())) {
                throw new EmailAlreadyExistsException("Пользователь с такой почтой уже есть в базе данных");
            }
        }
        if (!user.getEmail().contains("@")) {
            throw new InvalidEmailException("Указан некорректный адрес электронной почты");
        }
        return UserMapper.toUserDto(userRepository.save(UserMapper.toUser(user)));
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Collection<UserDto> getAll() {
        return UserMapper.toUserDtoList(userRepository.findAll());
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto patch(Integer userId, UserDto user) {
        for (User foundedUser : userRepository.findAll()) {
            if (user.getEmail() != null && user.getEmail().equals(foundedUser.getEmail())) {
                throw new EmailAlreadyExistsException("Пользователь с такой почтой уже есть в базе данных");
            }
        }
        return null;
//        return userRepository.patch(userId, UserMapper.toUser(user));
    }
}
