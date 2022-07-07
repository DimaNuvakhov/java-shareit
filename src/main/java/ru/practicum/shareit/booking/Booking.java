package ru.practicum.shareit.booking;

import lombok.Getter;
import lombok.Setter;
import ru.practicum.shareit.item.Item;
import ru.practicum.shareit.status.Status;
import ru.practicum.shareit.user.User;

import java.time.LocalDate;

@Getter
@Setter
public class Booking {
    private Integer id;
    private LocalDate start;
    private LocalDate end;
    private Item item;
    private User booker;
    private Status status;

    public Booking(Integer id, LocalDate start, LocalDate end, Item item, User booker, Status status) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.item = item;
        this.booker = booker;
        this.status = status;
    }
}


