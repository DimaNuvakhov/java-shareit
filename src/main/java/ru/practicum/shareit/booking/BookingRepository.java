package ru.practicum.shareit.booking;

import java.util.List;

public interface BookingRepository {

    BookingDto add(Booking booking);

    BookingDto update(Booking booking);

    BookingDto getById(Integer id);

    List<BookingDto> getAll();

    Boolean deleteById(Integer id);

}
