package ru.practicum.shareit.booking;

import java.util.HashMap;

public class BookingMapper {

    public static BookingDto toBookingDto(Booking booking) {
        return new BookingDto(booking.getId(), booking.getStart(), booking.getEnd(),
                booking.getItem(), booking.getStatus(), booking.getBooker());
    }

    public static HashMap<Integer, BookingDto> toBookingDtoMap(HashMap<Integer, Booking> bookings) {
        HashMap<Integer, BookingDto> bookingDtoMap = new HashMap<>();
        for (Booking booking : bookings.values()) {
            bookingDtoMap.put(booking.getId(), toBookingDto(booking));
        }
        return bookingDtoMap;
    }
}
