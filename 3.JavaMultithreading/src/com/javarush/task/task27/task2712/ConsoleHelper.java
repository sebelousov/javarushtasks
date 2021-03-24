package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String readLine = bufferedReader.readLine();
        return readLine;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        String dish = "";
        List<Dish> outDishes = new ArrayList<>();

        String dishesInString = Dish.allDishesToString();

        List<String> dishes = new ArrayList<>(Arrays.asList(dishesInString.split(", ")));
        List<String> temp = dishes.stream().map(String::toLowerCase).collect(Collectors.toList());

        writeMessage("Список блюд для заказа:");
        writeMessage(dishesInString);
        writeMessage("Пожалуйста, введите блюдо для заказа...");

        while (!dish.equals("exit")) {
            dish = readString().toLowerCase();
            if (temp.contains(dish)) {
                int index = temp.indexOf(dish);
                outDishes.add(Dish.values()[index]);
                ConsoleHelper.writeMessage("Добавлено в заказ. Введите новое или exit.");
                writeMessage(dishesInString);
            }
            else if (dish.equals("exit")) {

            }
            else {
                ConsoleHelper.writeMessage("Такого блюда нет, выберите другое или exit.");
                writeMessage(dishesInString);
            }
        }

        return outDishes;
    }

}
