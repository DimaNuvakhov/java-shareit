package ru.practicum.shareit.booking;

import java.util.ArrayList;
import java.util.List;

public class BookingMapper {

    public static BookingDto toBookingDto(Booking booking) {
        return new BookingDto(booking.getId(), booking.getStart(), booking.getEnd(),
                booking.getItemId() != null ? booking.getItemId() : null,
                booking.getBookerId() != null ? booking.getBookerId() : null,
                booking.getStatus() != null ? booking.getStatus() : null);
    }

    public static List<BookingDto> toBookingDtoList(List<Booking> bookings) {
        List<BookingDto> bookingDtoList = new ArrayList<>();
        for (Booking booking : bookings) {
            bookingDtoList.add(toBookingDto(booking));
        }
        return bookingDtoList;
    }

    public static Booking toBooking(BookingDto bookingDto) {
        return new Booking(bookingDto.getId(), bookingDto.getStart(), bookingDto.getEnd(),
                bookingDto.getItemId(), bookingDto.getBookerId(), setStatusName(bookingDto.getStatus()));
    }

    private static String setStatusName(String string) {
        switch (string) {
            case "WAITING":
                return Status.WAITING.toString();
            case "APPROVED":
                return Status.APPROVED.toString();
            case "REJECTED":
                return Status.REJECTED.toString();
            case "CANCELED":
                return Status.CANCELED.toString();
        }
        return null;
    }
}
