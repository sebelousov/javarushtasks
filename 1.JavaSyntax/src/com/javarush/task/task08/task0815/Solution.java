package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Петров", "Виктор");
        map.put("Сидоров", "Петр");
        map.put("Федоров", "Сидор");
        map.put("Комаров", "Виктор");
        map.put("Семенов", "Федор");
        map.put("Сергеев", "Виктор");
        map.put("Алов", "Петр");
        map.put("Алиев", "Петр");
        map.put("Алоев", "Петр");
        map.put("Алексеев", "Петр");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int x = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String value = pair.getValue();
            if (value.equals(name)) x++;
        }
        return x;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int x = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String key = pair.getKey();
            if (key.equals(lastName)) x++;
        }
        return x;
    }

    public static void main(String[] args) {

    }
}
