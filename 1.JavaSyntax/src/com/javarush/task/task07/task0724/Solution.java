package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human man00 = new Human("Степан", true, 15);
        Human man01 = new Human("Иван", true, 14);
        Human woman00 = new Human("Анна", false, 13);
        Human woman01 = new Human("Мария", false, 17);

        Human man03 = new Human("Федор", true, 25, man00, woman01);
        Human man04 = new Human("Сергей", true, 40, man01, woman00);
        Human woman02 = new Human("Юлия", false, 25, man00, woman00);
        Human woman03 = new Human("Жанна", false, 23, man00, woman01);
        Human woman04 = new Human("Марина", false, 30, man01, woman01);

        System.out.println(man00);
        System.out.println(man01);
        System.out.println(man03);
        System.out.println(man04);
        System.out.println(woman00);
        System.out.println(woman01);
        System.out.println(woman02);
        System.out.println(woman03);
        System.out.println(woman04);
        //напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        //напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}