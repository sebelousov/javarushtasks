package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {

        int x = 1;
        int y = 1;
        int z = 1;
        String text = "";

        while (y < 11) {

            while (x < 11){
                z = y * x;
                x = x + 1;
                text = text + " " + Integer.toString(z);
            }
            System.out.println(text);
            text = "";
            x = 1;
            y = y + 1;
        }
        //напишите тут ваш код
    }
}
