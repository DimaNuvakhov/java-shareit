package ru.practicum.shareit.item;

import java.util.List;

public interface ItemRepository {

    ItemDto add(Integer userId, Item item);

    ItemDto update(Integer userId, Item item);

    ItemDto getById(Integer userId, Integer itemId);

    List<ItemDto> getAll(Integer userId);

    Boolean deleteById(Integer userId, Integer itemId);
}
