package ru.practicum.shareit.booking;

import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class InMemoryBookingRepository implements BookingRepository {

    @Override
    public BookingDto add(Booking booking) {
        return null;
    }

    @Override
    public BookingDto update(Booking booking) {
        return null;
    }

    @Override
    public BookingDto getById(Integer id) {
        return null;
    }

    @Override
    public List<BookingDto> getAll() {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}
