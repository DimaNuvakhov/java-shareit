package ru.practicum.shareit.status;

import ru.practicum.shareit.booking.Booking;
import ru.practicum.shareit.booking.BookingDto;

import java.util.Collection;

public interface StatusService {

    StatusDto add(Status status);

    StatusDto update(Status status);

    StatusDto getById(Integer id);

    Collection<StatusDto> getAll();

    Boolean deleteById(Integer id);

}
