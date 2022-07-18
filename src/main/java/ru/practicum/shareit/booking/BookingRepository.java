package ru.practicum.shareit.booking;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

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


}
