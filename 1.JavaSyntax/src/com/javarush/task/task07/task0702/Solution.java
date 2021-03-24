package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] numbers = new String[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int n = 0; n < numbers.length - 2; n++){
            numbers[n] = reader.readLine();
        }

        for (int n = numbers.length - 1; n >= 0; n--){
            System.out.println(numbers[n]);
        }
        //напишите тут ваш код
    }
}