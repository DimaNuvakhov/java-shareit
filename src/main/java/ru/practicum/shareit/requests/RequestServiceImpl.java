package ru.practicum.shareit.requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public ItemRequestDto add(ItemRequest itemRequest) {
        return requestRepository.add(itemRequest);
    }

    @Override
    public ItemRequestDto update(ItemRequest itemRequest) {
        return requestRepository.update(itemRequest);
    }

    @Override
    public ItemRequestDto getById(Integer id) {
        return requestRepository.getById(id);
    }

    @Override
    public Collection<ItemRequestDto> getAll() {
        return requestRepository.getAll().values();
    }

    @Override
    public Boolean deleteById(Integer id) {
        return requestRepository.deleteById(id);
    }
}
