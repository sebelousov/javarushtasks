package com.javarush.task.task01.task0131;

/* 
Полнометражная картина
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getMetreFromCentimetre(243));
    }

    public static int getMetreFromCentimetre(int centimetre) {

        int amountMetre = centimetre / 100;
        return amountMetre;

        //напишите тут ваш код
    }
}