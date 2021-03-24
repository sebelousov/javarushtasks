package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human daughter = new Human("Mary", false, 5);
        Human daughter1 = new Human("Alisa", false, 10);
        Human son = new Human("John", true, 7);

        Human mother = new Human("Barbara", false, 25, daughter1, daughter, son);
        Human father = new Human("Jack", true, 30, daughter1, daughter, son);

        Human grandmother = new Human("Maria", false, 45, mother);
        Human grandfather = new Human("Teodor", true, 57, mother);
        Human grandmother2 = new Human("Kally", false, 42, father);
        Human grandfather2 = new Human("Donovan", true, 47, father);

        System.out.println(daughter);
        System.out.println(daughter1);
        System.out.println(son);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(grandmother);
        System.out.println(grandfather);
        System.out.println(grandmother2);
        System.out.println(grandfather2);

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human kid1) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.add(kid1);
        }

        public Human(String name, boolean sex, int age, Human kid1, Human kid2, Human kid3) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.add(kid1);
            this.children.add(kid2);
            this.children.add(kid3);
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
