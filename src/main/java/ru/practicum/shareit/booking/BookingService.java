package ru.practicum.shareit.booking;

import java.util.List;

public interface BookingService {

    BookingDto add(Integer userId, BookingDto bookingDto);

    BookingDto patch(Integer userId, Integer bookingId, Boolean approved);

    BookingDto getById(Integer userId, Integer bookingId);

    List<BookingDto> getAllBookingsByOwnerId(String state);

    List<BookingDto> getAllBookingsForAllItemsByOwnerId(String state);

}
