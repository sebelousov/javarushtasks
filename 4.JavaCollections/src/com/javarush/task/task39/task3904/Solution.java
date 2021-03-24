package com.javarush.task.task39.task3904;

import java.util.Arrays;

/*
Лестница
*/
public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        long[] steps = new long[n];

        for (int i = 0; i < 3; i++) {
            steps[i] = i;
        }

        for (int i = 3; i < steps.length; i++) {
            steps[i] = steps[i - 3] + steps[i - 2] + steps[i - 1];
        }

        return Arrays.stream(steps).sum() + 1;
    }
}

