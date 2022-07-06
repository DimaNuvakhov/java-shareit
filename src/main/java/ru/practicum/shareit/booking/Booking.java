package ru.practicum.shareit.booking;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Booking {
    private Integer id;
    private LocalDate start;
    private LocalDate end;
    private Integer item;
    private Integer booker;
    private Integer status;
}
