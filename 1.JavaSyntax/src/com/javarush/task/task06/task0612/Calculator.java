package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        int result = a + b;
        //напишите тут ваш код
        return result;
    }

    public static int minus(int a, int b) {
        int result = a - b;
        //напишите тут ваш код
        return result;
    }

    public static int multiply(int a, int b) {
        int result = a * b;
        //напишите тут ваш код
        return result;
    }

    public static double division(int a, int b) {
        double result = (a * 1.0) / (b * 1.0);
        //напишите тут ваш код
        return result;
    }

    public static double percent(int a, int b) {
        double result = b / 100.0 * a;
        //напишите тут ваш код
        return result;
    }

    public static void main(String[] args) {

    }
}