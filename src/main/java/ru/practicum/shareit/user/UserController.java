package ru.practicum.shareit.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User add(@RequestBody User user) {
//        return userService.add(user);
        return null;
    }

    @PutMapping
    public User update(@RequestBody User user) {
//        return userService.update(user);
        return null;
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
//        return userService.getById(userId);
        return null;
    }

    @GetMapping
    public List<User> getAll() {
//        return userService.getAll();
        return null;
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
//        return userService.deleteById();
        return null;
    }
}
