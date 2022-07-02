package ru.practicum.shareit.item;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class InMemoryItemRepository implements ItemRepository {

    HashMap<Integer, Item> items = new HashMap<>();

    @Override
    public ItemDto add(Item item) {
        if (!items.containsKey(item.getOwner())) {
            List<Item> ownerItems = new ArrayList<>();
            ownerItems.add(item);
        }
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
