package ru.practicum.shareit.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemRequestDto {
    private Integer id;
    private String description;
    private Integer requester;
    private LocalDateTime created;

    public ItemRequestDto(Integer id, String description, Integer requester, LocalDateTime created) {
        this.id = id;
        this.description = description;
        this.requester = requester;
        this.created = created;
    }
}
