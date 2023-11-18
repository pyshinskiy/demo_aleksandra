package com.example.demo.enitity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERINGS")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "NUMBER", nullable = false)
    private Integer number;

    @Column(name = "TOTAL")
    private Double total;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "ORDERINGS_DISHES",
        joinColumns = @JoinColumn(name = "ID_ORDERINGS"),
        inverseJoinColumns = @JoinColumn(name = "ID_DISHES")
    )
    private Set<Dish> dishes = new HashSet<>();

    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    public void removeDish(Dish dish) {
        this.dishes.remove(dish);
    }
}
