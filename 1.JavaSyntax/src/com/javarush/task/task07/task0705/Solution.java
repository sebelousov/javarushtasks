package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] bigDates = new int[20];
        int[] firstHalfDates = new int[10];
        int[] secondHalfDates = new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < bigDates.length; i++){
            bigDates[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < bigDates.length / 2; i++){
            firstHalfDates[i] = bigDates[i];
        }

        for (int i = 0; i < bigDates.length / 2; i++){
            secondHalfDates[i] = bigDates[i + 10];
            System.out.println(secondHalfDates[i]);
        }
        //напишите тут ваш код
    }
}
