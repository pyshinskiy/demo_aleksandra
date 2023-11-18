package com.example.demo.service;

import com.example.demo.enitity.Dish;
import com.example.demo.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;

    public Dish findByName(String name) {
        return dishRepository.findByName(name).orElseThrow();
    }

    public List<Dish> findByPriceBetween(Double from, Double to) {
        return dishRepository.findByPriceBetween(from, to);
    }

    public List<Dish> findByCategory(String category) {
        return dishRepository.findByCategoryName(category);
    }
}
