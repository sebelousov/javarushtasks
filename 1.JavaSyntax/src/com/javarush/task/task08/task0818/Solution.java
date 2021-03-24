package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Петров", 600);
        map.put("Васин", 700);
        map.put("Иванов", 800);
        map.put("Сидоров", 900);
        map.put("Федоров", 1000);
        map.put("Великанов", 100);
        map.put("Семенов", 600);
        map.put("Своеволин", 200);
        map.put("Климов", 300);
        map.put("Зарнев", 600);

        return map;
        //напишите тут ваш код
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            String key = pair.getKey();
            int value = pair.getValue();

            if (value < 500) iterator.remove();
        }

        //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}