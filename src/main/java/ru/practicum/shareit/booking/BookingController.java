package ru.practicum.shareit.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingDto add(@RequestHeader("X-Sharer-User-Id") Integer userId,
                          @RequestBody BookingDto booking) {
        return bookingService.add(userId, booking);
    }

    @PatchMapping("/{bookingId}")
    public BookingDto patch(@RequestHeader("X-Sharer-User-Id") Integer userId,
                            @PathVariable Integer bookingId,
                            @RequestParam(required = true) Boolean approved) {
        return bookingService.patch(userId, bookingId, approved);
    }

    @GetMapping("/{bookingId}")
    public BookingDto get(@RequestHeader("X-Sharer-User-Id") Integer userId,
                          @PathVariable Integer bookingId) {
        return bookingService.getById(userId, bookingId);
    }

    @GetMapping
    public Collection<BookingDto> getAllBookingsById(
            @RequestHeader("X-Sharer-User-Id") Integer userId,
            @RequestParam(defaultValue = "ALL", required = false) String state) {
        return bookingService.getAllBookingsByOwnerId(userId, state);
    }

    @GetMapping("/owner")
    public Collection<BookingDto> getAllBookingsForAllItemsById(
            @RequestParam(defaultValue = "ALL", required = false) String state) {
        return bookingService.getAllBookingsForAllItemsByOwnerId(state);
    }
}
