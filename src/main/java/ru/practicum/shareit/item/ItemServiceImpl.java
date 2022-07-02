package ru.practicum.shareit.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


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
