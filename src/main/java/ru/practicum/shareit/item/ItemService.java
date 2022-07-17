package ru.practicum.shareit.item;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    ItemDto add(Integer userId, ItemDto item);

    ItemDto getById(Integer itemId);

    List<ItemDto> getAll(Integer userId);

    ItemDto patch(Integer userId, Integer id, ItemDto item);

    List<ItemDto> search(String query);

    CommentDto addComment(Integer userId, Integer itemId, CommentDto comment);

}
