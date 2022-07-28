package ru.practicum.shareit.requests;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;

public interface RequestRepository extends JpaRepository<ItemRequest, Integer> {

}
