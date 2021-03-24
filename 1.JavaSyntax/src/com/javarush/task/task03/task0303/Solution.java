package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(convertEurToUsd(10, 1.1606));
        System.out.println(convertEurToUsd(25, 1.1606));

        //напишите тут ваш код
    }

    public static double convertEurToUsd(int eur, double course) {

        double convert1;

        convert1 = eur * course;

        return convert1;

        //напишите тут ваш код
    }
}
