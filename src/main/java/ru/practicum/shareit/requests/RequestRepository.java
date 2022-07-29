package ru.practicum.shareit.requests;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.shareit.item.ItemDto;

import java.util.List;

public interface RequestRepository extends JpaRepository<ItemRequest, Integer> {

    List<ItemRequest> getAllByRequesterIdOrderByCreated(Integer requesterId);

    Page<ItemRequest> findByIdIsNot(Integer requesterId, Pageable pageable);

}
