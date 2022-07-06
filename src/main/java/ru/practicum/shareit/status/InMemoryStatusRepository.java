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
        statuses.put(status.getId(), status);
        return StatusMapper.toStatusDto(status);
    }

    @Override
    public StatusDto getById(Integer id) {
        return StatusMapper.toStatusDto(statuses.get(id));
    }

    @Override
    public HashMap<Integer, StatusDto> getAll() {
        return StatusMapper.toStatusDtoMap(statuses);
    }

    @Override
    public Boolean deleteById(Integer id) {
        statuses.remove(id);
        return true;
    }
}
