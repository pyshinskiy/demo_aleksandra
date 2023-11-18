package com.example.demo.repository;

import com.example.demo.enitity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Integer> {

    Optional<Dish> findByName(String name);

    List<Dish> findByPriceBetween(Double from, Double to);

    @Query("SELECT d FROM Dish d LEFT JOIN d.category c WHERE c.name = ?1")
    List<Dish> findByCategoryName(String name);
}
