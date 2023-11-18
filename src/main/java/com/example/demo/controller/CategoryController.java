package com.example.demo.controller;

import com.example.demo.dto.CategoryDto;
import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    private final ModelMapper modelMapper;

    @GetMapping
    public List<CategoryDto> getAll() {
        return categoryService.findAll()
                .stream()
                .map(c -> modelMapper.map(c, CategoryDto.class))
                .toList();
    }
}
