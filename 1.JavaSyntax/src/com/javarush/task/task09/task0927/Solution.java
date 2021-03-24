package com.javarush.task.task09.task0927;

import java.lang.reflect.Array;
import java.util.*;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<String, Cat>();
        int count = 10;

        for (int i = 0; i < count; i++) {
            map.put("Name" + i, new Cat("Name" + i));
        }

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        ArrayList<Cat> list = new ArrayList<Cat>(map.values());
        Set<Cat> set = new HashSet<Cat>(map.values());

        for (Cat cat : list) {
            set.add(cat);
        }

        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
