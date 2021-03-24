package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String secondName;
        private String family;
        private int age;
        private int weight;
        private int sleeve;

        public Human(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
        public Human(String name, String secondName, String family, int age, int weight, int sleeve) {
            this.name = name;
            this.secondName = secondName;
            this.family = family;
            this.age = age;
            this.weight = weight;
            this.sleeve = sleeve;
        }
        public Human(String family) {
            this.family = family;
        }
        public Human(String secondName, String family, int age, int weight, int sleeve) {
            this.secondName = secondName;
            this.family = family;
            this.age = age;
            this.weight = weight;
            this.sleeve = sleeve;
        }
        public Human(String family, int age, int weight, int sleeve) {
            this.family = family;
            this.age = age;
            this.weight = weight;
            this.sleeve = sleeve;
        }
        public Human(String secondName, int sleeve, String name) {
            this.secondName = secondName;
            this.sleeve = sleeve;
            this.name = name;
        }

        public Human(String name, String secondName, String family) {
            this.name = name;
            this.secondName = secondName;
            this.family = family;
        }
        public Human(String name, String family) {
            this.name = name;
            this.family = family;
        }
        public Human(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
        public Human(int weight, int sleeve) {
            this.weight = weight;
            this.sleeve = sleeve;
        }
        // напишите тут ваши переменные и конструкторы
    }
}
