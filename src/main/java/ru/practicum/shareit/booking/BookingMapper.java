package ru.practicum.shareit.booking;

import java.util.ArrayList;
import java.util.List;

public class BookingMapper {

    public static ReturnedBookingDto toReturnedBookingDto(Booking booking) {
        return new ReturnedBookingDto(booking.getId(), booking.getStart(), booking.getEnd(),
                booking.getItem() != null ? booking.getItem() : null,
                booking.getBooker() != null ? booking.getBooker() : null,
                booking.getStatus() != null ? booking.getStatus() : null);
    }

    public static List<ReturnedBookingDto> toBookingDtoList(List<Booking> bookings) {
        List<ReturnedBookingDto> returnedBookingDtoList = new ArrayList<>();
        for (Booking booking : bookings) {
            returnedBookingDtoList.add(toReturnedBookingDto(booking));
        }
        return returnedBookingDtoList;
    }

    public static Booking toBooking(ResultingBookingDto resultingBookingDto) {
        return new Booking(resultingBookingDto.getId(), resultingBookingDto.getStart(), resultingBookingDto.getEnd(),
                null, null, null);
    }

    public static ItemBookingDto toItemBookingDto(Booking booking) {
        return new ItemBookingDto(booking.getId() != null ? booking.getId() : null,
                booking.getBooker().getId() != null ? booking.getBooker().getId() : null);
    }
}
