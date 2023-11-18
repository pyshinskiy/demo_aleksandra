package com.example.demo.repository;

import com.example.demo.enitity.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryDishRepository extends JpaRepository<DishCategory, Integer> {

}
