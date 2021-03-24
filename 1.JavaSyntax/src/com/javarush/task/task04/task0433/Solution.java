package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        String s = "S";
        int x = 0;
        int y = 0;

        while (y < 10){
            while (x < 9){
                System.out.print(s);
                x++;
            }
            System.out.println(s);
            x = 0;
            y++;
        }
        //напишите тут ваш код

    }
}
