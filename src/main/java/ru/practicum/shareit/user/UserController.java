package ru.practicum.shareit.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto add(@RequestBody User user) {
        return userService.add(user);
    }

    @PutMapping
    public UserDto update(@RequestBody User user) {
        return userService.update(user);
    }

    @PatchMapping("/{id}")
    public UserDto patch(@PathVariable Integer id,
                         @RequestBody User user) {
        return userService.patch(id, user);
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return userService.deleteById(id);
    }
}
