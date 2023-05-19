package ru.job4j.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.dish.model.Dish;
import ru.job4j.dish.repository.DishRepository;

@Service
@AllArgsConstructor
public class SimpleDishService implements DishService {

    private DishRepository dishRepository;

    @Override
    public Dish save(Dish dish) {
        try {
            return dishRepository.save(dish);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("%s already exist", dish.getName()));
        }
    }

    @Override
    public Dish findById(int id) {
        return dishRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "dish ID does not exist"));
    }

    @Override
    @Transactional
    public void update(Dish dish) {
        if (!dishRepository.existsById(dish.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "dish ID does not exist");
        }
        dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void delete(int id) {
        if (!dishRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "dish ID does not exist");
        }
        dishRepository.deleteById(id);
    }
}
