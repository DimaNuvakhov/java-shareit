package ru.practicum.shareit.item;

import lombok.Getter;
import lombok.Setter;

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
