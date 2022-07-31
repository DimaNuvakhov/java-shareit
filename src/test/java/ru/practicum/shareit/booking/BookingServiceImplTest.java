package ru.practicum.shareit.booking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.practicum.shareit.error.InvalidAccessException;
import ru.practicum.shareit.error.ItemNotFoundException;
import ru.practicum.shareit.error.UserNotFoundException;
import ru.practicum.shareit.item.Item;
import ru.practicum.shareit.item.ItemDto;
import ru.practicum.shareit.item.ItemRepository;
import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.UserDto;
import ru.practicum.shareit.user.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class BookingServiceImplTest {

    BookingService bookingService;
    BookingRepository bookingRepository = Mockito.mock(BookingRepository.class);
    ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
    UserRepository userRepository = Mockito.mock(UserRepository.class);
    LocalDateTime date = LocalDateTime.of(2022, 8, 20, 13, 12);
    ResultingBookingDto resultingBookingDto = new ResultingBookingDto(
            1, date, date.plusDays(1), 1, 2, Status.WAITING.toString());
    ItemDto itemDto = new ItemDto(1, "Отвертка", "Хорошая отвертка", true, 1,
            null, null, null);
    UserDto userDto = new UserDto(1, "user", "user@mail.ru");
    User user = new User(1, "user", "user@mail.ru");
    User secondUser = new User(2, "second User", "secondUser@mail.ru");
    ReturnedBookingDto returnedBookingDto = new ReturnedBookingDto(
            1, date, date.plusDays(1), itemDto, userDto, Status.WAITING.toString());
    Item item = new Item(1, "Отвертка", "Хорошая отвертка", true, 1, 2);
    Booking booking = new Booking(1, date, date.plusDays(1), item, user, Status.WAITING.toString());

    @BeforeEach
    void BeforeEach() {
        bookingService = new BookingServiceImpl(bookingRepository, itemRepository,
                userRepository);
    }

    @Test
    void add() {
        Mockito
                .when(itemRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.ofNullable(item));
        Mockito
                .when(userRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.ofNullable(secondUser));
        Mockito
                .when(userRepository.existsUserById(Mockito.anyInt()))
                .thenReturn(true);
        Mockito
                .when(itemRepository.existsItemById(Mockito.anyInt()))
                .thenReturn(true);
        Mockito
                .when(bookingRepository.save(Mockito.any(Booking.class)))
                .thenReturn(booking);
        ReturnedBookingDto foundedReturnedBookingDto = bookingService.add(2, resultingBookingDto);
        assertThat(foundedReturnedBookingDto.getId(), equalTo(returnedBookingDto.getId()));
        assertThat(foundedReturnedBookingDto.getStart(), equalTo(returnedBookingDto.getStart()));
        assertThat(foundedReturnedBookingDto.getEnd(), equalTo(returnedBookingDto.getEnd()));
        assertThat(foundedReturnedBookingDto.getStatus(), equalTo(returnedBookingDto.getStatus()));
    }

    @Test
    void failAddUserNotFound() {
        Mockito
                .when(itemRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.ofNullable(item));
        Mockito
                .when(userRepository.findById(Mockito.anyInt()))
                .thenThrow(new InvalidAccessException("Пользователь с данным id не найден"));
        final InvalidAccessException exception = Assertions.assertThrows(InvalidAccessException.class,
                () -> bookingService.add(1, resultingBookingDto));
        Assertions.assertEquals("Пользователь с данным id не найден", exception.getMessage());
    }

    @Test
    void failAddItemNotFound() {
        Mockito
                .when(itemRepository.findById(Mockito.anyInt()))
                .thenThrow(new ItemNotFoundException("Вещь с данным id не найдена"));
        final ItemNotFoundException exception = Assertions.assertThrows(ItemNotFoundException.class,
                () -> bookingService.add(2, resultingBookingDto));
        Assertions.assertEquals("Вещь с данным id не найдена", exception.getMessage());

    }

    @Test
    void failAddUserNotExists() {
        Mockito
                .when(itemRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.ofNullable(item));
        Mockito
                .when(userRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.ofNullable(secondUser));
        Mockito
                .when(itemRepository.existsItemById(Mockito.anyInt()))
                .thenReturn(true);
        Mockito
                .when(userRepository.existsUserById(Mockito.anyInt()))
                .thenThrow(new UserNotFoundException("Пользователь с данным id не найден в базе"));
        final UserNotFoundException exception = Assertions.assertThrows(UserNotFoundException.class,
                () -> bookingService.add(2, resultingBookingDto));
        Assertions.assertEquals("Пользователь с данным id не найден в базе", exception.getMessage());
    }

    @Test
    void failAddItemNotExists() {
        Mockito
                .when(itemRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.ofNullable(item));
        Mockito
                .when(userRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.ofNullable(secondUser));
        Mockito
                .when(itemRepository.existsItemById(Mockito.anyInt()))
                .thenThrow(new ItemNotFoundException("Вещь с данным id не найдена в базе"));

        final ItemNotFoundException exception = Assertions.assertThrows(ItemNotFoundException.class,
                () -> bookingService.add(2, resultingBookingDto));
        Assertions.assertEquals("Вещь с данным id не найдена в базе", exception.getMessage());
    }

    @Test
    void patch() {
        Mockito
                .when(itemRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.ofNullable(item));
        Mockito
                .when(bookingRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.ofNullable(booking));
        Mockito
                .when(bookingRepository.save(Mockito.any(Booking.class)))
                .thenReturn(booking);
        ReturnedBookingDto foundedReturnedBookingDto = bookingService.patch(1, 1, true);
        assertThat(foundedReturnedBookingDto.getId(), equalTo(returnedBookingDto.getId()));
        assertThat(foundedReturnedBookingDto.getStart(), equalTo(returnedBookingDto.getStart()));
        assertThat(foundedReturnedBookingDto.getEnd(), equalTo(returnedBookingDto.getEnd()));
        assertThat(foundedReturnedBookingDto.getStatus(), equalTo(Status.APPROVED.toString()));
    }

    @Test
    void getById() {
        Mockito
                .when(itemRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.ofNullable(item));
        Mockito
                .when(bookingRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.ofNullable(booking));
        ReturnedBookingDto foundedReturnedBookingDto = bookingService.getById(1, 1);
        assertThat(foundedReturnedBookingDto.getId(), equalTo(returnedBookingDto.getId()));
        assertThat(foundedReturnedBookingDto.getStart(), equalTo(returnedBookingDto.getStart()));
        assertThat(foundedReturnedBookingDto.getEnd(), equalTo(returnedBookingDto.getEnd()));
        assertThat(foundedReturnedBookingDto.getStatus(), equalTo(returnedBookingDto.getStatus()));
    }

    @Test
    void getAllBookingsByOwnerIdAllState() {
        // TODO это в базу
    }

    @Test
    void getAllBookingsForAllItemsByOwnerId() {
        // TODO это в базу
    }
}