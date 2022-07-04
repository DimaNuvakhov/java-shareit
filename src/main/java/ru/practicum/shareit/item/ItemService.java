package ru.practicum.shareit.item;

import org.springframework.stereotype.Service;
import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.UserDto;

import java.util.List;

@Service
public interface ItemService {

    ItemDto add(Integer userId, Item item);

    ItemDto update(Integer userId, Item item);

    ItemDto getById(Integer userId, Integer itemId);

    List<ItemDto> getAll(Integer userId);

    Boolean deleteById(Integer userId, Integer itemId);
}
