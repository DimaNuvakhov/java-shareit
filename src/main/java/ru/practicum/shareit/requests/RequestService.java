package ru.practicum.shareit.requests;

import java.util.Collection;

public interface RequestService {

    ItemRequestDto add(ItemRequest itemRequest);

    ItemRequestDto update(ItemRequest itemRequest);

    ItemRequestDto getById(Integer id);

    Collection<ItemRequestDto> getAll();

    Boolean deleteById(Integer id);

}
