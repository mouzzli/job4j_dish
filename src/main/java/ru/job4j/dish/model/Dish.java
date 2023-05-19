package ru.job4j.dish.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "dish")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    private String description;
}
