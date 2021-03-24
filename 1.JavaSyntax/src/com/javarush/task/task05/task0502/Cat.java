package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int y = 100;
        int x = 100;
        boolean result = true;

        if (this.age > 1 && this.age < 7) {
            x = x * this.age;
        }
        else {
            x = x / this.age;
        }


        if (anotherCat.age >1 && anotherCat.age < 7) {
            y = y * anotherCat.age;
        }
        else {
            y = y / anotherCat.age;
        }

        if (this.weight > 2 && this.weight < 8) {
            x = x + this.weight;
        }
        else {
            x = x - this.weight;
        }

        if (anotherCat.weight >2 && anotherCat.weight < 8) {
            y = y + anotherCat.weight;
        }
        else {
            y = y - anotherCat.weight;
        }

        x = x * this.strength;
        y = y * anotherCat.strength;

        if (x < y) result = false;
        return result;
        //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}
