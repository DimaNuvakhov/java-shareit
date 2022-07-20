package ru.practicum.shareit.item;

import lombok.Getter;
import lombok.Setter;
import ru.practicum.shareit.user.User;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {

    private Integer id;

    private String text;

    private Item item;

    private User author;

    private LocalDateTime created;

    public CommentDto(Integer id, String text, Item item, User author, LocalDateTime created) {
        this.id = id;
        this.text = text;
        this.item = item;
        this.author = author;
        this.created = created;
    }
}
