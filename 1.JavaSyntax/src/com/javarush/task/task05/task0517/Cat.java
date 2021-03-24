package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    String name, address, color;
    int age, weight;

    public Cat(String name){
        this.name = name;
        color = "red";
        age = 3;
        weight = 5;
    }
    public Cat(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        color = "red";
    }
    public Cat(String name, int age){
        this.name = name;
        weight = 5;
        this.age = age;
        color = "red";
    }
    public Cat(int weight, String color){
        this.weight = weight;
        age = 7;
        this.color = color;
    }
    public Cat(int weight, String color, String address){
        this.weight = weight;
        age = 2;
        this.color = color;
        this.address = address;
    }

    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
