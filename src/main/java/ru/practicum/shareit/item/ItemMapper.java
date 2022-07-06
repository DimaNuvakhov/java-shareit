package ru.practicum.shareit.item;

import java.util.HashMap;

public class ItemMapper {

    public static ItemDto toItemDto(Item item) {
        return new ItemDto(item.getId(), item.getName(),
                item.getDescription(), item.getAvailable(), item.getOwner(), item.getRequest());
    }

    public static HashMap<Integer, ItemDto> toItemDtoMap(HashMap<Integer, Item> items) {
        HashMap<Integer, ItemDto> itemDtos = new HashMap<>();
        for (Item item : items.values()) {
            itemDtos.put(item.getId(), toItemDto(item));
        }
        return itemDtos;
    }

}
