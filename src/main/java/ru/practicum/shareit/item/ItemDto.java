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
//    private User owner;
//    private ItemRequest request;
}
