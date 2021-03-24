package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/



public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        StackTraceElement[] x = Thread.currentThread().getStackTrace();
        System.out.println(x[2].getClassName() + ": " + x[2].getMethodName() + ": " + s);
        //напишите тут ваш код
    }
}
