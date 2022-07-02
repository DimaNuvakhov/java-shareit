package ru.practicum.shareit.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.UserDto;
import ru.practicum.shareit.user.UserRepository;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ItemDto add(Integer ownerId, Item item) {
        item.setOwner(ownerId);
//      return itemRepository.add(item);
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
