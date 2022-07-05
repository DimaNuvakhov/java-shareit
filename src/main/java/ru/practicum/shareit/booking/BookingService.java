package ru.practicum.shareit.booking;

import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.UserDto;

import java.util.Collection;
import java.util.List;

public interface BookingService {

    BookingDto add(Booking booking);

    BookingDto update(Booking booking);

    BookingDto getById(Integer id);

    Collection<BookingDto> getAll();

    Boolean deleteById(Integer id);

}
