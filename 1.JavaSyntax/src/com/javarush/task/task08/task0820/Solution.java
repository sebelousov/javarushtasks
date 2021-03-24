package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();
        int cats = 4;
        //напишите тут ваш код
        for (int i = 0; i < cats; i++) {
            result.add(new Cat());
        }
        return result;
    }

    public static Set<Dog> createDogs() {
        //напишите тут ваш код
        HashSet<Dog> result1 = new HashSet<Dog>();
        int dogs = 3;
        for (int i = 0; i < dogs; i++) {
            result1.add(new Dog());
        }
        return result1;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        HashSet<Object> pets = new HashSet<Object>();

        for (Cat cat : cats) {
            pets.add(cat);
        }

        for (Dog dog : dogs) {
            pets.add(dog);
        }

        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        pets.removeAll(cats);
    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        for (Object x : pets) {
            System.out.println(x);
        }
    }

    //напишите тут ваш код

    public static class Cat {
        private String name;

    }

    public static class Dog {
        private String name;

    }


}
