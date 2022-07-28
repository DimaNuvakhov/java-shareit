package ru.practicum.shareit.requests;

import lombok.Getter;
import lombok.Setter;
import ru.practicum.shareit.item.Item;
import ru.practicum.shareit.item.ItemDto;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemRequestDto {
    private Integer id;
    private String description;
    private Integer requester;
    private LocalDateTime created;

    private ItemDto item;

    public ItemRequestDto(Integer id, String description, Integer requester, LocalDateTime created, ItemDto item) {
        this.id = id;
        this.description = description;
        this.requester = requester;
        this.created = created;
        this.item = item;
    }
}
