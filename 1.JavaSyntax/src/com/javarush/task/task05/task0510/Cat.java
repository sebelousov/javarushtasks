package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    String name;
    int age;
    int weight;
    String address;
    String color;

    public void initialize(String name) {
        this.name = name;
        this.age = 3;
        this.weight = 5;
        this.color = "рыжий";
    }
    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "рыжий";
    }
    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 5;
        this.color = "рыжий";
    }
    public void initialize(int weight, String color) {
        this.age = 3;
        this.weight = weight;
        this.color = color;
    }
    public void initialize(int weight, String color, String address) {
        this.age = 3;
        this.weight = weight;
        this.address = address;
        this.color = color;
    }

    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
