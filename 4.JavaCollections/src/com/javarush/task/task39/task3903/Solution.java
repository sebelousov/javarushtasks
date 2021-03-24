package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Неравноценный обмен
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        if (i < 0 || j < 0 || i == j) return number;

        if ((number & (1L << i)) != 0) {
            // 1
            if ((number & (1L << j)) != 0) {
                return number;
            }
            else {
                number = number ^ 1 << i;
                number = number ^ 1 << j;
            }
        }
        else {
            if ((number & (1L << j)) != 0) {
                number = number ^ 1 << i;
                number = number ^ 1 << j;
            }
            else {
                return number;
            }
        }
        return number;

//        System.out.println(Long.toBinaryString(number));
//        long a = number >> i & 1;
//        long b = number >> j & 1;
//
//        if (a != b)
//            number = number & ~((1 << i) | (1 << j)) | (a << j) | (b << i);
//        System.out.println(Long.toBinaryString(number));
//        return number;
    }
}
