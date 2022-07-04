package ru.practicum.shareit.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ItemDto add(@RequestHeader("X-Sharer-User-Id") Integer userId,
                    @RequestBody Item item) {
        return itemService.add(userId, item);
    }

    @PutMapping
    public Item update(@RequestHeader("X-Sharer-User-Id") Integer userId,
                       @RequestBody Item item) {
//        return itemService.update(userId, item);
        return null;
    }

    @GetMapping("{itemId}")
    public ItemDto get(@RequestHeader("X-Sharer-User-Id") Integer userId,
                       @PathVariable Integer itemId) {
        return itemService.getById(userId, itemId);

    }

    @GetMapping
    public List<Item> getAll(@RequestHeader("X-Sharer-User-Id") Integer userId) {
//        return itemService.getAll();
        return null;
    }

    @GetMapping("/search")
    public List<Item> search(@RequestParam(required = true) String query,
                             @RequestParam(required = false) List<String> by) {
//        return itemService.search(query, by);
        return null;
    }
}
