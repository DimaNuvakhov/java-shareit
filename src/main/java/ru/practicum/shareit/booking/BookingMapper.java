package ru.practicum.shareit.booking;

import ru.practicum.shareit.status.Status;

import java.util.HashMap;

public class BookingMapper {

    public static BookingDto toBookingDto(Booking booking) {
        return new BookingDto(booking.getId(), booking.getStart(), booking.getEnd(),
                booking.getItemId() != null ? booking.getItemId() : null,
                booking.getBookerId() != null ? booking.getBookerId() : null,
                booking.getStatus() != null ? booking.getStatus().toString() : null);
    }

    public static HashMap<Integer, BookingDto> toBookingDtoMap(HashMap<Integer, Booking> bookings) {
        HashMap<Integer, BookingDto> bookingDtoMap = new HashMap<>();
        for (Booking booking : bookings.values()) {
            bookingDtoMap.put(booking.getId(), toBookingDto(booking));
        }
        return bookingDtoMap;
    }

    public static Booking toBooking(BookingDto bookingDto) {
        return new Booking(bookingDto.getId(), bookingDto.getStart(), bookingDto.getEnd(),
                bookingDto.getItemId(), bookingDto.getBookerId(), toStatusFromString(bookingDto.getStatus()));
    }

    private static Status toStatusFromString(String string) {
        if (string.equals("WAITING")) {
            return Status.WAITING;
        } else if (string.equals("APPROVED")) {
            return Status.APPROVED;
        } else if (string.equals("REJECTED")) {
            return Status.REJECTED;
        } else if (string.equals("CANCELED")) {
            return Status.CANCELED;
        }
        return null;
    }
}
