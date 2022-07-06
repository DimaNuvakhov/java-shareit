package ru.practicum.shareit.requests;

import java.util.HashMap;

public class RequestMapper {
    public static ItemRequestDto toItemRequestDto(ItemRequest itemRequest) {
        return new ItemRequestDto(itemRequest.getId(), itemRequest.getDescription(),
                itemRequest.getRequestor(), itemRequest.getCreated());
    }

    public static HashMap<Integer, ItemRequestDto> toItemRequestMap(HashMap<Integer, ItemRequest> itemRequests) {
        HashMap<Integer, ItemRequestDto> itemRequestDtoMap = new HashMap<>();
        for (ItemRequest itemRequest : itemRequests.values()) {
            itemRequestDtoMap.put(itemRequest.getId(), toItemRequestDto(itemRequest));
        }
        return itemRequestDtoMap;
    }
}
