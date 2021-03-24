package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int x = 0;
        int y = 0;

        String text00 = "количество отрицательных чисел: ";
        String text01 = "количество положительных чисел: ";

        if (a > 0 && a != 0) x++;
        if (b > 0 && b != 0) x++;
        if (c > 0 && c != 0) x++;

        if (a < 0 && a != 0) y++;
        if (b < 0 && b != 0) y++;
        if (c < 0 && c != 0) y++;

        System.out.println(text01 + Integer.toString(x));
        System.out.println(text00 + Integer.toString(y));
        //напишите тут ваш код

    }
}
