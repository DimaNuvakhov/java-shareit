package ru.practicum.shareit.status;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class InMemoryStatusRepository implements StatusRepository {

    HashMap<Integer, Status> statuses = new HashMap<>();

    private Integer idMax = 0;

    private Integer getIdMax() {
        idMax = idMax + 1;
        return idMax;
    }

    @Override
    public StatusDto add(Status status) {
        status.setId(getIdMax());
        statuses.put(status.getId(), status);
        return StatusMapper.toStatusDto(status);
    }

    @Override
    public StatusDto update(Status status) {
        return null;
    }

    @Override
    public StatusDto getById(Integer id) {
        return null;
    }

    @Override
    public HashMap<Integer, StatusDto> getAll() {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}
