package ru.job4j.dish.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dish.model.Dish;
import ru.job4j.dish.service.DishService;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/dishes")
@AllArgsConstructor
public class DishController {

    private DishService dishService;

    @PostMapping
    private ResponseEntity<Map<String, String>> create(@RequestBody Dish dish, @ModelAttribute Dish dishModel) {
        dishService.save(dish);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap("status", "created"));
    }

    @GetMapping("/{id}")
    public Dish findById(@PathVariable int id) {
        return dishService.findById(id);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> update(@RequestBody Dish dish) {
        dishService.update(dish);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap("status", "updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable int id) {
        dishService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap("status", "deleted"));
    }
}
