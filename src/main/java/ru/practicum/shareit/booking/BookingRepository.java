package ru.practicum.shareit.booking;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByBookerIdOrderByStartDesc(Integer bookerId);

    List<Booking> findByBookerIdAndStartIsBeforeAndEndIsAfterOrderByStartDesc
            (Integer bookerId, LocalDateTime dateOne, LocalDateTime dateTwo);

    List<Booking> findByBookerIdAndStartIsAfterAndEndIsAfterOrderByStartDesc
            (Integer bookerId, LocalDateTime dateOne, LocalDateTime dateTwo);

    List<Booking> findByBookerIdAndStartIsBeforeAndEndIsBeforeOrderByStartDesc
            (Integer bookerId, LocalDateTime dateOne, LocalDateTime dateTwo);

    List<Booking> findByBookerIdAndStatusContainsOrderByStartDesc(Integer bookerId, String status);

    Boolean existsByBookerIdAndItemIdAndEndIsAfter(Integer bookerId, Integer itemId, LocalDateTime end);

    @Query("select b from Booking b Inner Join Item i on b.item.id = i.id " +
            "Where i.ownerId = ?1 " +
            "order by b.start desc")
    List<Booking> findAllUsersBookings(Integer ownerId);

    @Query("select b from Booking b Inner Join Item i on b.item.id = i.id " +
            "Where i.ownerId = ?1 and ?2 between b.start and b.end " +
            "order by b.start desc")
    List<Booking> findAllCurrentUsersBookings(Integer ownerId, LocalDateTime date);

    @Query("select b from Booking b Inner Join Item i on b.item.id = i.id " +
            "Where i.ownerId = ?1 and ?2 >= b.end and ?3 >= b.start " +
            "order by b.start desc")
    List<Booking> findAllPastUsersBookings(Integer ownerId, LocalDateTime dateOne, LocalDateTime dateTwo);

    @Query("select b from Booking b Inner Join Item i on b.item.id = i.id " +
            "Where i.ownerId = ?1 and ?2 <= b.end and ?3 <= b.start " +
            "order by b.start desc")
    List<Booking> finnAllFutureUsersBookings(Integer ownerId, LocalDateTime dateOne, LocalDateTime dateTwo);

    @Query("select b from Booking b Inner Join Item i on b.item.id = i.id " +
            "Where i.ownerId = ?1 and b.status like ?2 " +
            "order by b.start desc")
    List<Booking> findAllUsersBookingsWithStatus(Integer ownerId, String query);


}
