package ru.practicum.shareit.status;

import java.util.HashMap;

public interface StatusRepository {

    StatusDto add(Status status);

    StatusDto update(Status status);

    StatusDto getById(Integer id);

    HashMap<Integer, StatusDto> getAll();

    Boolean deleteById(Integer id);
}
