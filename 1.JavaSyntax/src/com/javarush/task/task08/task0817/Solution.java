package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Иванов", "Петр");
        map.put("Петров", "Игорь");
        map.put("Сидоров", "Петр");
        map.put("Васильев", "Федор");
        map.put("Климов", "Петр");
        map.put("Сергеев", "Виктор");
        map.put("Семенов", "Петр");
        map.put("Игнатов", "Василий");
        map.put("Соловьев", "Иван");
        map.put("Федоров", "Виктор");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код

        ArrayList<String> list = new ArrayList<String>(map.values());

        int count;

        for (String string : list) {
            count = 0;
            for (String string1 : list) {
                if (string.equals(string1)) count++;
                if (count == 2) removeItemFromMapByValue(map, string);
            }
        }

    }



    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}

