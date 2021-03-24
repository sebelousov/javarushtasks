package com.javarush.task.task03.task0304;

/* 
Задача на проценты
*/

public class Solution {
    public static double addTenPercent(int i) {

        double proc = 1.1;
        double sum = i * proc;
        return sum;
        //напишите тут ваш код
    }

    public static void main(String[] args) {
        System.out.println(addTenPercent(9));
    }
}
