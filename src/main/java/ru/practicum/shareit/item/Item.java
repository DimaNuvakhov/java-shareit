package ru.practicum.shareit.item;

import lombok.Getter;
import lombok.Setter;
import ru.practicum.shareit.requests.ItemRequest;
import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.UserDto;

@Getter
@Setter
public class Item {
private Integer id;
private String name;
private String description;
private Boolean available;
private Integer owner;
private Integer request;
}
