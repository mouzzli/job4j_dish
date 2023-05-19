package ru.job4j.dish.service;

import ru.job4j.dish.model.Dish;

public interface DishService {

    Dish save(Dish dish);

    Dish findById(int id);

    void update(Dish dish);

    void delete(int id);
}
