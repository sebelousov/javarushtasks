package com.javarush.task.task14.task1421;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        getInstance();
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        else {

        }
        return instance;
    }
}
