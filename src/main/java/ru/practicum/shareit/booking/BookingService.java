package ru.practicum.shareit.booking;

import java.util.Collection;

public interface BookingService {

    BookingDto add(Booking booking);

    BookingDto update(Booking booking);

    BookingDto getById(Integer id);

    Collection<BookingDto> getAll();

    Boolean deleteById(Integer id);

}
