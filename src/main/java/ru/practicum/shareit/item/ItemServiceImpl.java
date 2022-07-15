package ru.practicum.shareit.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.error.*;
import ru.practicum.shareit.user.User;
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
    public ItemDto add(Integer ownerId, ItemDto item) {
        if (ownerId == null) {
            throw new InvalidIdException("Ошибка id пользователя");
        }
        if (userRepository.findAll().isEmpty()) {
            throw new IdNotFoundException("Ни один пользователь не добавлен в систему");
        }
        if (item.getAvailable() == null) {
            throw new InvalidAvailableException("Не задан статус вещи");
        }
        if (item.getName() == null || item.getName().isBlank()) {
            throw new InvalidNameException("Не задано имя вещи");
        }
        if (item.getDescription() == null || item.getDescription().isBlank()) {
            throw new InvalidDescriptionException("Не задано описание вещи");
        }
//        if (!userRepository.getAll().containsKey(ownerId)) {
//            throw new IdNotFoundException("Id пользователя не найден в базе");
//        }
        Item createdItem = ItemMapper.toItem(item);
        User user = userRepository.findById(ownerId).orElse(new User());
        createdItem.setOwnerId(user.getId());
        return ItemMapper.toItemDto(itemRepository.save(createdItem));
    }

    @Override
    public ItemDto getById(Integer itemId) {
        Item item = itemRepository.findById(itemId).orElse(new Item());
        return ItemMapper.toItemDto(item);
    }

    @Override
    public List<ItemDto> getAll(Integer userId) {
//        if (!userRepository.getAll().containsKey(userId)) {
//            throw new InvalidUserException("Пользователь не добавлен в систему");
//        }
        List<ItemDto> itemDtos = ItemMapper.toItemDtoList(itemRepository.getAllByOwnerIdContains(userId));
        return itemDtos;
    }

//    @Override
//    public Boolean deleteById(Integer userId, Integer itemId) {
//        return null;
//    }

    @Override
    public ItemDto patch(Integer userId, Integer id, ItemDto item) {
        Item foundedItem = itemRepository.findById(id).orElse(new Item());
        if (userId == null) {
            throw new InvalidIdException("Ошибка id пользователя");
        }
        if (!foundedItem.getOwnerId().equals(userId)) {
            throw new InvalidUserException("Редактировать вещь может только ее владелец");
        }
        if (item.getName() != null) {
            foundedItem.setName(item.getName());
        }
        if (item.getDescription() != null) {
            foundedItem.setDescription(item.getDescription());
        }
        if (item.getAvailable() != null) {
            foundedItem.setAvailable(item.getAvailable());
        }
        return ItemMapper.toItemDto(itemRepository.save(foundedItem));
    }

//    @Override
//    public List<ItemDto> search(String query) {
//        if (query.isBlank()) {
//            return new ArrayList<>();
//        }
//        String lowerCaseQuery = query.toLowerCase();
//        return itemRepository.search(lowerCaseQuery);
//    }
}
