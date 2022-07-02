package ru.practicum.shareit.item;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InMemoryItemRepository implements ItemRepository {

    @Override
    public ItemDto add(Integer userId, Item item) {
        return null;
    }

    @Override
    public ItemDto update(Integer userId, Item item) {
        return null;
    }

    @Override
    public ItemDto getById(Integer userId, Integer itemId) {
        return null;
    }

    @Override
    public List<ItemDto> getAll(Integer userId) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer userId, Integer itemId) {
        return null;
    }
}
