package ru.practicum.shareit.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

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
