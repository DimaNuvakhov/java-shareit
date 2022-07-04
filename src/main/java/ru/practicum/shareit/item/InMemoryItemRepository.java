package ru.practicum.shareit.item;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class InMemoryItemRepository implements ItemRepository {

    HashMap<Integer, Item> items = new HashMap<>();

    private Integer idMax = 0;

    private Integer getIdMax() {
        idMax = idMax + 1;
        return idMax;
    }
    @Override
    public ItemDto add(Item item) {
        item.setId(getIdMax());
        items.put(item.getId(), item);
        return ItemMapper.toItemDto(items.get(item.getId()));
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
