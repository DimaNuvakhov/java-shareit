package ru.practicum.shareit.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemRequest {
    private Integer id;
    private String description;
    private Integer requestor;
    private LocalDateTime created;
}
