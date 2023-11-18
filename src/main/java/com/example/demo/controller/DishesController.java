package com.example.demo.controller;

import com.example.demo.dto.DishDto;
import com.example.demo.service.DishService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dish")
@RequiredArgsConstructor
public class DishesController {

    private final DishService dishService;

    private final ModelMapper modelMapper;

    @GetMapping("/{name}")
    public DishDto findByName(@PathVariable("name") String name) {
        return modelMapper.map(dishService.findByName(name), DishDto.class);
    }

    @GetMapping("/price/{from}/{to}")
    public List<DishDto> findByPriceBetween(@PathVariable("from") Double from, @PathVariable("to") Double to) {
        return dishService.findByPriceBetween(from, to)
                .stream()
                .map(d -> modelMapper.map(d, DishDto.class))
                .toList();
    }

    @GetMapping("/category/{name}")
    public List<DishDto> findByCategory(@PathVariable("name") String category) {
        return dishService.findByCategory(category)
                .stream()
                .map(d -> modelMapper.map(d, DishDto.class))
                .toList();
    }
}
