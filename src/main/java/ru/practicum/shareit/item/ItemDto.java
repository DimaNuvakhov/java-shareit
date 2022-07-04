package ru.practicum.shareit.item;

import lombok.Getter;
import lombok.Setter;
import ru.practicum.shareit.requests.ItemRequest;
import ru.practicum.shareit.user.User;
@Getter
@Setter
public class ItemDto {
    private Integer id;
    private String name;
    private String description;
    private boolean available;
//    private Integer owner;
//    private Integer request;


    public ItemDto(Integer id, String name, String description, boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.available = available;
    }
}
