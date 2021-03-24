package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        setDefaultUncaughtExceptionHandler((t, e) -> {
            if (e.getClass().getName().contains("Error")) System.out.println("Нельзя дальше работать");
            else if (e.getClass().getName().contains("Exception")) System.out.println("Надо обработать");
            else System.out.println("Поживем - увидим");
        });
    }

    public static void main(String[] args) {

    }
}
