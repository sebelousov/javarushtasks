package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }

    private static String getAllNumbersBetween(int a, int b) {
        int difference = Math.abs(a - b) + 1;
        StringBuilder builder = new StringBuilder();

        if (a > b) {
            for (int i = difference; i > 0; i--) {
                builder.append(a--);
                if (i != 1) builder.append(" ");
            }
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            for (int i = difference; i > 0; i--) {
                builder.append(a++);
                if (i != 1) builder.append(" ");
            }
        }
        return builder.toString();
    }
}