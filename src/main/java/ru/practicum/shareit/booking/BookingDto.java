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
//    private Item item;
//    private User booker;
//    private Status status;
}


