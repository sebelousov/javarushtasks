package com.javarush.task.task12.task1210;

/* 
Три метода и максимум
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int max(int x, int y) {
        int max = 0;
        if (x >= y) max = x;
        if (x <= y) max = y;
        return max;
    }

    public static long max(long x, long y) {
        long max = 0;
        if (x >= y) max = x;
        if (x <= y) max = y;
        return max;
    }

    public static double max(double x, double y) {
        double max = 0;
        if (x >= y) max = x;
        if (x <= y) max = y;
        return max;
    }
    //Напишите тут ваши методы
}
