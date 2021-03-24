package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("Sam", 10, "Moscow");
        Man man2 = new Man("Crys", 20, "Leningrad");
        System.out.println(man1.name + " " + Integer.toString(man1.age) + " " + man1.address);
        System.out.println(man2.name + " " + Integer.toString(man2.age) + " " + man2.address);

        Woman woman1 = new Woman("Loren", 12, "Saratov");
        Woman woman2 = new Woman("Salva", 14, "Novgorod");
        System.out.println(woman1.name + " " + Integer.toString(woman1.age) + " " + woman1.address);
        System.out.println(woman2.name + " " + Integer.toString(woman2.age) + " " + woman2.address);

        //напишите тут ваш код
    }

    public static class Man{
        String name;
        int age;
        String address;

        Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    public static class Woman{
        String name;
        int age;
        String address;

        Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    //напишите тут ваш код
}
