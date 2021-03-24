package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        int x = 1;
        int y = 1;

        while (y < 11){
            while (x < 10){
                System.out.print(Integer.toString(y * x) + " ");
                x++;
            }
            System.out.println(y * x);
            x = 1;
            y++;
        }
        //напишите тут ваш код

    }
}
