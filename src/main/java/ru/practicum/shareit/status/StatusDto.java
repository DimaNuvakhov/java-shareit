package ru.practicum.shareit.status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusDto {
    Integer id;
    String value;

    public StatusDto(Integer id, String value) {
        this.id = id;
        this.value = value;
    }
}
