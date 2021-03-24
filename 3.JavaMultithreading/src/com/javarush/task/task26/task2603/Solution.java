package com.javarush.task.task26.task2603;

import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {
        Set<Human> humans = new TreeSet<>();
        humans.add(new Human("Antonov", 50, 30));
        humans.add(new Human("Antonov", 30, 30));
        humans.add(new Human("Antonov", 30, 20));
        humans.add(new Human("Ivanov", 40, 40));
        humans.add(new Human("Semenov", 50, 30));
        humans.add(new Human("Inakov", 50, 30));
        humans.add(new Human("Petrov", 50, 30));
        humans.add(new Human("Bulikin", 50, 30));
        for (Human human : humans) {
            System.out.println(human);
        }
    }

    public static class Human {
        private String name;
        private int height;
        private int age;

        public Human(String name, int height, int age) {
            this.name = name;
            this.height = height;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getHeight() {
            return height;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", age=" + age +
                    '}';
        }
    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        @SafeVarargs
        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (Comparator<T> comparator : comparators) {
                result = comparator.compare(o1, o2);
                if (result != 0) return result;
            }
            return result;
        }
    }
}
