package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    private boolean empty = true;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        if (!dishes.isEmpty()) empty = false;
    }

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public int getTotalCookingTime() {
        int sum = 0;
        if (!dishes.isEmpty()) {
            for (Dish d : dishes) {
                sum += d.getDuration();
            }
        }
        return sum;
    }

    public boolean isEmpty() {
        return empty;
    }

    @Override
    public String toString() {
        if (!dishes.isEmpty()) {
            return String.format("Your order: %s of %s, cooking time %dmin", dishes.toString(), tablet, getTotalCookingTime());
        }
        else {
            return "";
        }
    }
}
