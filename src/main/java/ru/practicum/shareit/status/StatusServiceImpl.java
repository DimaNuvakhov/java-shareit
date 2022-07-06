package ru.practicum.shareit.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public StatusDto add(Status status) {
        return statusRepository.add(status);
    }

    @Override
    public StatusDto update(Status status) {
        return statusRepository.update(status);
    }

    @Override
    public StatusDto getById(Integer id) {
        return statusRepository.getById(id);
    }

    @Override
    public Collection<StatusDto> getAll() {
        return statusRepository.getAll().values();
    }

    @Override
    public Boolean deleteById(Integer id) {
        return statusRepository.deleteById(id);
    }
}
