package ru.practicum.shareit.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.booking.BookingRepository;
import ru.practicum.shareit.error.*;
import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    private final BookingRepository bookingRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, UserRepository userRepository,
                           CommentRepository commentRepository, BookingRepository bookingRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.bookingRepository = bookingRepository;
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
        if (!userRepository.existsUserById(ownerId)) {
            throw new IdNotFoundException("Id пользователя не найден в базе");
        }
        Item createdItem = ItemMapper.toItem(item);
        User user = userRepository.findById(ownerId).
                orElseThrow(() -> new UserNotFoundException("Пользователь с id " + ownerId + " не найдена"));
        createdItem.setOwnerId(user.getId());
        return ItemMapper.toItemDto(itemRepository.save(createdItem));
    }

    @Override
    public ItemDto getById(Integer itemId) {
        Item item = itemRepository.findById(itemId).
                orElseThrow(() -> new ItemNotFoundException("Вещь с id " + itemId + " не найдена"));
        return ItemMapper.toItemDto(item);
    }

    @Override
    public List<ItemDto> getAll(Integer userId) {
        if (!userRepository.existsUserById(userId)) {
            throw new InvalidUserException("Пользователь не добавлен в систему");
        }
        List<ItemDto> itemDtos = ItemMapper.toItemDtoList(itemRepository.getAllByOwnerId(userId));
        return itemDtos;
    }

    @Override
    public ItemDto patch(Integer userId, Integer id, ItemDto item) {
        Item foundedItem = itemRepository.
                findById(id).orElseThrow(() -> new ItemNotFoundException("Вещь с id " + id + " не найдена"));
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

    @Override
    public List<ItemDto> search(String query) {
        List<Item> items = new ArrayList<>();
        if (query.isBlank()) {
            return new ArrayList<>();
        }
        List<Item> foundedItems = itemRepository.search(query);
        for (Item item : foundedItems) {
            if (item.getAvailable()) {
                items.add(item);
            }
        }
        return ItemMapper.toItemDtoList(items);
    }

    @Override
    public CommentDto addComment(Integer userId, Integer itemId, CommentDto commentDto) {
        Comment createdComment = CommentMapper.toComment(commentDto);
        createdComment.setItemId(itemId);
        createdComment.setAuthorId(userId);
        if (!bookingRepository.existsByBookerIdAndItemIdAndEndIsAfter
                (createdComment.getAuthorId(), createdComment.getItemId(), LocalDateTime.now())) {
            throw new InvalidCommentException("Оставлять отзыв может только тот пользователь, который брал " +
                    "вещь в аренду и только после окончания срока аренды");
        }
        return CommentMapper.toCommentDto(commentRepository.save(createdComment));
    }
}
