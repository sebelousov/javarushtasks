package com.javarush.task.task12.task1219;

/* 
Создаем человека
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        public void fly();
    }

    public interface Run {
        public void run();
    }

    public interface Swim {
        public void swim();
    }


    public class Human implements Run, Swim {
        public void run() {

        }
        public void swim() {

        }
    }

    public class Duck implements Run, Swim, Fly {
        public void fly() {

        }
        public void run() {

        }
        public void swim() {

        }
    }

    public class Penguin implements Run, Swim {
        public void run() {

        }
        public void swim() {

        }
    }

    public class Airplane implements Run, Fly {
        public void run() {

        }
        public void fly() {

        }
    }
}
