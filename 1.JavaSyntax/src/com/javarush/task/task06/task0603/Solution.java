package com.javarush.task.task06.task0603;

/* 
По 50 000 объектов Cat и Dog
*/

public class Solution {
    public static void main(String[] args) {
        for (int i = 50000; i > 0; i--){
            Cat cat1 = new Cat();
        }
        for (int i = 50000; i > 0; i--){
            Dog dog1 = new Dog();
        }
        //напишите тут ваш код
    }
}

class Cat {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Cat was destroyed");
    }
}

class Dog {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Dog was destroyed");
    }
}
