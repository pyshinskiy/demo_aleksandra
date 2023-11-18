package com.example.demo.service;

import com.example.demo.enitity.DishCategory;
import com.example.demo.repository.CategoryDishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryDishRepository repository;

    public List<DishCategory> findAll() {
        return repository.findAll();
    }
}
