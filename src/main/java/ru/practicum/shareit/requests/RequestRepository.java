package ru.practicum.shareit.requests;

import ru.practicum.shareit.status.Status;
import ru.practicum.shareit.status.StatusDto;

import java.util.HashMap;

public interface RequestRepository {

    ItemRequestDto add(ItemRequest itemRequest);

    ItemRequestDto update(ItemRequest itemRequest);

    ItemRequestDto getById(Integer id);

    HashMap<Integer, ItemRequestDto> getAll();

    Boolean deleteById(Integer id);

}
