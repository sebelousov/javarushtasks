package com.javarush.task.task04.task0409;

/* 
Ближайшее к 10
*/

public class Solution {
    public static void main(String[] args) {
        closeToTen(8, 11);
        closeToTen(7, 14);
    }

    public static void closeToTen(int a, int b) {

        int s = Solution.abs(10 - a);
        int s1 = Solution.abs(10 - b);

        if (s < s1){
            s = a;
        }
        else{
            s = b;
        }
        System.out.println(s);
        //напишите тут ваш код

    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}