package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[20];
        int maximum;
        int minimum;

        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(reader.readLine());
        }
        maximum = list[0];
        minimum = list[0];

        for (int j = 0; j < list.length; j++) {
            if (list[j] > maximum) maximum = list[j];
            if (list[j] < minimum) minimum = list[j];
        }
        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }
}
