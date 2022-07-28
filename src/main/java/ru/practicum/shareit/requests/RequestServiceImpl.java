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
    public ItemRequestDto add(Integer userId, ItemRequestDto itemRequest) {
        return null;
    }

    @Override
    public ItemRequestDto getById(Integer userId, Integer requestId) {
        return null;
    }

    @Override
    public Collection<ItemRequestDto> getAllUsersRequests(Integer userId) {
        return null;
    }

    @Override
    public Collection<ItemRequestDto> getAllRequests(Integer userId, Integer from, Integer size) {
        return null;
    }
}
