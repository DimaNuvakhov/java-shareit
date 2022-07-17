package ru.practicum.shareit.booking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
