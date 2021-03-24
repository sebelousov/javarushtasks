package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int q = 0;

        if (a > 0 && b > 0) q = 1;
        if (a < 0 && b > 0) q = 2;
        if (a < 0 && b < 0) q = 3;
        if (a > 0 && b < 0) q = 4;

        System.out.println(q);
        //напишите тут ваш код
    }
}
