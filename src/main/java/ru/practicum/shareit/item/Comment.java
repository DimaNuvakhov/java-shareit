package ru.practicum.shareit.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "comments")
@Entity
@Getter
@Setter
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "author_id")
    private Integer authorId;

    private LocalDateTime created;

    public Comment(Integer id, String text, Integer itemId, Integer authorId, LocalDateTime created) {
        this.id = id;
        this.text = text;
        this.itemId = itemId;
        this.authorId = authorId;
        this.created = created;
    }

    public Comment() {

    }
}
