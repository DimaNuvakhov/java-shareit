package ru.practicum.shareit.requests;

import lombok.Getter;
import lombok.Setter;
import ru.practicum.shareit.user.User;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemRequest {
    private Integer id;
    private String description;
    private User requestor;
    private LocalDateTime created;

    public ItemRequest(Integer id, String description, User requestor, LocalDateTime created) {
        this.id = id;
        this.description = description;
        this.requestor = requestor;
        this.created = created;
    }
}
