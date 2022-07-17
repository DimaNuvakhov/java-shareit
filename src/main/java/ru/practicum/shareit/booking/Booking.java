package ru.practicum.shareit.booking;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.practicum.shareit.status.Status;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "bookings")
@Entity
@Getter
@Setter
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "start_date_time")
    private LocalDateTime start;
    @Column(name = "end_date_time")
    private LocalDateTime end;
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "booker_id")
    private Integer bookerId;
    private Status status;

    public Booking(Integer id, LocalDateTime start, LocalDateTime end, Integer itemId, Integer bookerId, Status status) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.itemId = itemId;
        this.bookerId = bookerId;
        this.status = status;
    }

    public Booking() {

    }
}


