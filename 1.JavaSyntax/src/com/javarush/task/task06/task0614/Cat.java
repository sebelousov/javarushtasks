package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<Cat>();
    //напишите тут ваш код

    public Cat() {

    }

    public static void main(String[] args) {
        int countOfCats = 10;
        for (int i = 0; i < countOfCats; i++){
            cats.add(new Cat());
        }
        //напишите тут ваш код
        printCats();
    }

    public static void printCats() {
        int countOfCats = 10;
        for (int j = 0; j < countOfCats; j++){
            System.out.println(cats.get(j));
        }
        //напишите тут ваш код
    }
}
