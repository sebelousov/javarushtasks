package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int evenSum = 0;
        int oddSum = 0;
        int[] wholeNumbers = new int[15];
        String evenText = "В домах с четными номерами проживает больше жителей.";
        String oddText = "В домах с нечетными номерами проживает больше жителей.";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < wholeNumbers.length; i++){
            wholeNumbers[i] = Integer.parseInt(reader.readLine());
            if (i % 2 == 0){
                evenSum += wholeNumbers[i];
            }
            else {
                oddSum += wholeNumbers[i];
            }
        }
        if (evenSum > oddSum){
            System.out.println(evenText);
        }
        else {
            System.out.println(oddText);
        }
        //напишите тут ваш код
    }
}
