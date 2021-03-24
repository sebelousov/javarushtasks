package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] texts = new String[10];
        int[] numbers = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < texts.length; i++){
            texts[i] = reader.readLine();
        }

        for (int i = 0; i < texts.length; i++){
            numbers[i] = texts[i].length();
            System.out.println(numbers[i]);
        }
        //напишите тут ваш код
    }
}
