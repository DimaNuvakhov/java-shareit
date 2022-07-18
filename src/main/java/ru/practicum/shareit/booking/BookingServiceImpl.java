package ru.practicum.shareit.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.error.*;
import ru.practicum.shareit.item.Item;
import ru.practicum.shareit.item.ItemRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        bookingDto.setStatus(Status.WAITING.toString());
        bookingDto.setBookerId(userId);
        Booking booking = BookingMapper.toBooking(bookingDto);
        if (!itemRepository.existsItemById(booking.getItemId())) {
            throw new ItemNotFoundException("Вещь с id " + booking.getItemId() + " не найдена");
        }
//        if (booking.getEnd().is) { TODO доделать
//
//        }
        return BookingMapper.toBookingDto(bookingRepository.save(booking));
        // TODO Добавить валидацию
    }

    @Override
    public BookingDto patch(Integer userId, Integer bookingId, Boolean approved) {
        Booking booking = bookingRepository.findById(bookingId).
                orElseThrow(() -> new BookingNotFoundException("Бронирование с id " + bookingId + " не найдено"));
        Item item = itemRepository.findById(booking.getItemId()).
                orElseThrow(() -> new ItemNotFoundException("Вещь с id " + booking.getItemId() + " не найдена"));
        if (!userId.equals(item.getOwnerId())) {
            throw new InvalidAccessException
                    ("Подтверждение или отклонение запроса на бронирование может быть выполнено только владельцем вещи");
        }
        if (!booking.getStatus().equals("WAITING")) {
            throw new InvalidStatusException("Статус бронирования должен принимать значение \"WAITING\"");
        }
        if (approved) {
            booking.setStatus(Status.APPROVED.toString());
        } else {
            booking.setStatus(Status.REJECTED.toString());
        }
        return BookingMapper.toBookingDto(bookingRepository.save(booking));
    }

    @Override
    public BookingDto getById(Integer userId, Integer bookingId) {
        Booking booking = bookingRepository.findById(bookingId).
                orElseThrow(() -> new BookingNotFoundException("Бронирование с id " + bookingId + " не найдено"));
        Item item = itemRepository.findById(booking.getItemId()).
                orElseThrow(() -> new ItemNotFoundException("Вещь с id " + booking.getItemId() + " не найдена"));
        if (!(userId.equals(item.getOwnerId())) || !(userId.equals(booking.getBookerId()))) {
            throw new InvalidAccessException
                    ("Получить данные о конкрутном бронировании может либо автор бронирования, либо владелей вещи");
        }
        return BookingMapper.toBookingDto(bookingRepository.findById(bookingId).orElse(new Booking()));
    }

    @Override
    public List<BookingDto> getAllBookingsByOwnerId(Integer userId, String state) {
        if (state.equals("ALL")) {
            return BookingMapper.toBookingDtoList
                    (bookingRepository.findByBookerIdOrderByStartDesc(userId));
        }
        if (state.equals("CURRENT")) {
            return BookingMapper.toBookingDtoList
                    (bookingRepository.findByBookerIdAndStartIsBeforeAndEndIsAfterOrderByStartDesc
                            (userId, LocalDateTime.now(), LocalDateTime.now()));
        }
        if (state.equals("PAST")) {
            return BookingMapper.toBookingDtoList
                    (bookingRepository.findByBookerIdAndStartIsBeforeAndEndIsBeforeOrderByStartDesc
                            (userId, LocalDateTime.now(), LocalDateTime.now()));
        }
        if (state.equals("FUTURE")) {
            return BookingMapper.toBookingDtoList
                    (bookingRepository.findByBookerIdAndStartIsAfterAndEndIsAfterOrderByStartDesc
                            (userId, LocalDateTime.now(), LocalDateTime.now()));
        }
        if (state.equals("WAITING")) {
            return BookingMapper.toBookingDtoList
                    (bookingRepository.findByBookerIdAndStatusContainsOrderByStartDesc
                            (userId, Status.WAITING.toString()));
        }
        if (state.equals("REJECTED")) {
            return BookingMapper.toBookingDtoList
                    (bookingRepository.findByBookerIdAndStatusContainsOrderByStartDesc
                            (userId, Status.REJECTED.toString()));
        }
        return new ArrayList<>();
    }

    @Override
    public List<BookingDto> getAllBookingsForAllItemsByOwnerId(Integer userId, String state) {
        // TODO запрос имеет смысл для владельца хотя бы одной вещи
        if (state.equals("ALL")) {
           return BookingMapper.toBookingDtoList(bookingRepository.findAllUsersBookings(userId));
        }
        if (state.equals("CURRENT")) {
            return BookingMapper.toBookingDtoList
                    (bookingRepository.findAllCurrentUsersBookings(userId, LocalDateTime.now()));
        }
        if (state.equals("PAST")) {
            return BookingMapper.toBookingDtoList(bookingRepository.findAllPastUsersBookings
                    (userId, LocalDateTime.now(), LocalDateTime.now()));
        }
        if (state.equals("FUTURE")) {
            return BookingMapper.toBookingDtoList(bookingRepository.finnAllFutureUsersBookings
                    (userId, LocalDateTime.now(), LocalDateTime.now()));
        }
        if (state.equals("WAITING")) {
            return BookingMapper.toBookingDtoList
                    (bookingRepository.findAllUsersBookingsWithStatus(userId, Status.WAITING.toString()));
        }
        if (state.equals("REJECTED")) {
            return BookingMapper.toBookingDtoList
                    (bookingRepository.findAllUsersBookingsWithStatus(userId, Status.REJECTED.toString()));
        }
        return new ArrayList<>();
    }
}
