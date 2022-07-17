package ru.practicum.shareit.booking;

import ru.practicum.shareit.status.Status;

import java.util.ArrayList;
import java.util.List;

public class BookingMapper {

    public static BookingDto toBookingDto(Booking booking) {
        return new BookingDto(booking.getId(), booking.getStart(), booking.getEnd(),
                booking.getItemId() != null ? booking.getItemId() : null,
                booking.getBookerId() != null ? booking.getBookerId() : null,
                booking.getStatus() != null ? booking.getStatus().toString() : null);
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
                bookingDto.getItemId(), bookingDto.getBookerId(), toStatusFromString(bookingDto.getStatus()));
    }

    private static Status toStatusFromString(String string) {
        switch (string) {
            case "WAITING":
                return Status.WAITING;
            case "APPROVED":
                return Status.APPROVED;
            case "REJECTED":
                return Status.REJECTED;
            case "CANCELED":
                return Status.CANCELED;
        }
        return null;
    }
}
