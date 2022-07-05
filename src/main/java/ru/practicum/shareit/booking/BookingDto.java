package ru.practicum.shareit.booking;

import lombok.Getter;
import lombok.Setter;
import ru.practicum.shareit.item.Item;
import ru.practicum.shareit.status.Status;
import ru.practicum.shareit.user.User;

import java.time.LocalDate;
@Getter
@Setter
public class BookingDto {
    private Integer id;
    private LocalDate start;
    private LocalDate end;
    private Integer item;
    private Integer booker;
    private Integer status;

    public BookingDto(Integer id, LocalDate start, LocalDate end, Integer item, Integer booker, Integer status) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.item = item;
        this.booker = booker;
        this.status = status;
    }
}


