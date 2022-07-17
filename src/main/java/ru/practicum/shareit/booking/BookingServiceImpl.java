package ru.practicum.shareit.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.item.Item;
import ru.practicum.shareit.item.ItemRepository;
import ru.practicum.shareit.status.Status;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ItemRepository itemRepository;


    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, ItemRepository itemRepository) {
        this.bookingRepository = bookingRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public BookingDto add(Integer userId, BookingDto bookingDto) {
        Booking booking = BookingMapper.toBooking(bookingDto);
        booking.setBookerId(userId);
        booking.setStatus(Status.WAITING);
        return BookingMapper.toBookingDto(bookingRepository.save(booking));
        // TODO Добавить валидацию
    }

    @Override
    public BookingDto patch(Integer userId, Integer bookingId, Boolean approved) {
        Booking booking = bookingRepository.findById(bookingId).orElse(new Booking());
        Item item = itemRepository.findById(booking.getItemId()).orElse(new Item());
        if (!userId.equals(item.getOwnerId())) {
//            throw new
        }
        if (approved) {
            booking.setStatus(Status.APPROVED);
        } else {
            booking.setStatus(Status.REJECTED);
        }
        return BookingMapper.toBookingDto(bookingRepository.save(booking));
    }

    @Override
    public BookingDto getById(Integer userId, Integer bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(new Booking());
        Item item = itemRepository.findById(booking.getItemId()).orElse(new Item());
        if (!(userId.equals(item.getOwnerId())) || !(userId.equals(booking.getBookerId()))) {
            // throw new
        }
        return BookingMapper.toBookingDto(bookingRepository.findById(bookingId).orElse(new Booking()));
    }

    @Override
    public List<BookingDto> getAllBookingsByOwnerId(String state) {
        return null;
    }

    @Override
    public List<BookingDto> getAllBookingsForAllItemsByOwnerId(String state) {
        return null;
    }
}
