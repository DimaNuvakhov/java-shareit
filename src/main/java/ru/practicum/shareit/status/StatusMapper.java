package ru.practicum.shareit.status;

import java.util.HashMap;

public class StatusMapper {
    public static StatusDto toStatusDto(Status status) {
        return new StatusDto(status.getId(), status.getValue());
    }

    public static HashMap<Integer, StatusDto> toStatusDtoMap (HashMap<Integer, Status> statuses) {
        HashMap<Integer, StatusDto> statusDtoMap = new HashMap<>();
        for (Status status : statuses.values()) {
            statusDtoMap.put(status.getId(), toStatusDto(status));
        }
        return statusDtoMap;
    }
}
