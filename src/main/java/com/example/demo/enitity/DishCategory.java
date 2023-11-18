package com.example.demo.enitity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "CATEGORY_DISHES")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DishCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
    private Set<Dish> dishes;
}
