package ru.practicum.shareit.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
        return bookingRepository.add(booking);
    }

    @Override
    public BookingDto update(Booking booking) {
        return bookingRepository.update(booking);
    }

    @Override
    public BookingDto getById(Integer id) {
        return bookingRepository.getById(id);
    }

    @Override
    public Collection<BookingDto> getAll() {
        return bookingRepository.getAll().values();
    }

    @Override
    public Boolean deleteById(Integer id) {
        return bookingRepository.deleteById(id);
    }
}
