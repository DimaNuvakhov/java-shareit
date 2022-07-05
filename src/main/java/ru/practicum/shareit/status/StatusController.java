package ru.practicum.shareit.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/status")
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    public StatusDto add(@RequestBody Status status) {
        return statusService.add(status);
    }

    @PutMapping
    public StatusDto update(@RequestBody Status status) {
        return statusService.update(status);
    }

    @GetMapping("/{id}")
    public StatusDto get(@PathVariable Integer id) {
        return statusService.getById(id);
    }

    @GetMapping
    public Collection<StatusDto> getAll() {
        return statusService.getAll();
    }

    @DeleteMapping
    public Boolean delete(@PathVariable Integer id) {
        return statusService.deleteById(id);
    }
}
