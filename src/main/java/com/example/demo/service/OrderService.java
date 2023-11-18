package com.example.demo.service;

import com.example.demo.enitity.Dish;
import com.example.demo.enitity.Order;
import com.example.demo.repository.DishRepository;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final DishRepository dishRepository;

    private final OrderRepository orderRepository;

    public List<Dish> findDishesByOrderId(Integer orderId) {
        return orderRepository.findOrderWithDishesById(orderId)
                .orElseThrow()
                .getDishes()
                .stream()
                .toList();
    }

    public void addDishToOrder(Integer dishId, Integer orderId) {
        Dish dish = dishRepository.findById(dishId).orElseThrow();
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.addDish(dish);
        orderRepository.save(order);
    }

    public void removeDishFromOrder(Integer dishId, Integer orderId) {
        Dish dish = dishRepository.findById(dishId).orElseThrow();
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.removeDish(dish);
        orderRepository.save(order);
    }

    public void clearOrder(Integer orderId) {
        Order order = orderRepository.findOrderWithDishesById(orderId).orElseThrow();
        order.setDishes(Collections.emptySet());
        orderRepository.save(order);
    }

    public Order processOrder(Integer orderId) {
        Order order = orderRepository.findOrderWithDishesById(orderId).orElseThrow();
        order.setTotal(order.getDishes().stream().mapToDouble(Dish::getPrice).sum());
        return order;
    }

    public Order createOrder() {
        Order newOrder = new Order();
        newOrder.setNumber(ThreadLocalRandom.current().nextInt()); // костыль из-за того что в миграциях поле указано NOT NUL, в идеале его генерировать в БД как id
        return orderRepository.save(newOrder);
    }
}
