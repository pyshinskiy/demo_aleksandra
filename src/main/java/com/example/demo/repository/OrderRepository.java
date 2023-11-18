package com.example.demo.repository;

import com.example.demo.enitity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.dishes d WHERE o.id = ?1")
    Optional<Order> findOrderWithDishesById(Integer id);
}
