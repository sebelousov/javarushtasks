package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(81));
    }

    public static boolean isPowerOfThree(int n) {
        while (n > 3) {
            if (n % 3 == 0) n /= 3;
            else break;
        }

        if (n == 1) return true;
        if (n == 0 || n == 2 || n % 3 != 0) return false;


        return true;
    }
}
