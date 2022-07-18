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

    @Query("select b.id, b.start, b.end, b.itemId, b.bookerId, b.status  " +
            "from Booking as b Inner Join Item as i on b.itemId = i.id " +
            "Where i.ownerId = ?1 " +
            "order by b.start desc")
    List<Booking> findAllUsersBookings(Integer ownerId);

}
