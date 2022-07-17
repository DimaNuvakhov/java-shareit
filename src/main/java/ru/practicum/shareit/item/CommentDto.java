package ru.practicum.shareit.item;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {

    private Integer id;

    private String text;

    private Integer itemId;

    private Integer authorId;

    private LocalDateTime created;

    public CommentDto(Integer id, String text, Integer itemId, Integer authorId, LocalDateTime created) {
        this.id = id;
        this.text = text;
        this.itemId = itemId;
        this.authorId = authorId;
        this.created = created;
    }
}
