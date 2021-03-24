package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int i) {
        this.duration = i;
    }

    public static String allDishesToString() {
        Dish[] dishes = values();
        String temp = Arrays.toString(dishes);
        return temp.substring(1, temp.length() - 1);
    }

    public int getDuration() {
        return duration;
    }
}
