package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("Петров", "Иван");
        map.put("Васечкин", "Семен");
        map.put("Иванов", "Сергей");
        map.put("Сидоров", "Игорь");
        map.put("Семенов", "Василий");
        map.put("Петров", "Василий");
        map.put("Васечкин", "Игорь");
        map.put("Иванов", "Семен");
        map.put("Сидоров", "Сергей");
        map.put("Семенов", "Иван");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
