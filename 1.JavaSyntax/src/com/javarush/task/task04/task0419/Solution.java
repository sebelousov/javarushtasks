package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());

        System.out.println(MostNumber(a, b, c, d));

        //напишите тут ваш код
    }
    public static int MostNumber(int a, int b, int c, int d) {
        int x = 0;
        if (a >= b && a >= c && a >= d) x = a;
        if (b >= a && b >= c && b >= d) x = b;
        if (c >= a && c >= b && c >= d) x = c;
        if (d >= a && d >= b && d >= c) x = d;
        return x;
    }
}
