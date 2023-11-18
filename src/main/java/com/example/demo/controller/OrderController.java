package com.example.demo.controller;

import com.example.demo.dto.DishDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final ModelMapper modelMapper;

    private final OrderService orderService;

    @PostMapping
    public OrderDto createOrder() {
        return modelMapper.map(orderService.createOrder(), OrderDto.class);
    }

    @PostMapping("/addDish")
    public void addDish(@RequestParam("dishId") Integer dishId, @RequestParam("orderId") Integer orderId) {
        orderService.addDishToOrder(dishId, orderId);
    }

    @PostMapping("/removeDish")
    public void removeDish(@RequestParam("dishId") Integer dishId, @RequestParam("orderId") Integer orderId) {
        orderService.removeDishFromOrder(dishId, orderId);
    }

    @PostMapping("/clearOrder")
    public void clearOrder(@RequestParam("orderId") Integer orderId) {
        orderService.clearOrder(orderId);
    }

    @PostMapping("/processOrder")
    public OrderDto processOrder(@RequestParam("orderId") Integer orderId) {
        return modelMapper.map(orderService.processOrder(orderId), OrderDto.class);
    }

    @GetMapping("/{orderId}/dishes")
    public List<DishDto> getDishes(@PathVariable("orderId") Integer orderId) {
        return orderService.findDishesByOrderId(orderId)
                .stream()
                .map(d -> modelMapper.map(d, DishDto.class))
                .toList();
    }
}
