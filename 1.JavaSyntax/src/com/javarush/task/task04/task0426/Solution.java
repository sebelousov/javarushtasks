package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());

        String TextPlus = "положительное ";
        String TextChet = "четное ";
        String SlovoChislo = "число";
        String Zero = "ноль";

        if (a == 0){
            System.out.println(Zero);
        }
        else {
            if (a > 0){
                TextPlus = "положительное ";
            }
            else {
                TextPlus = "отрицательное ";
            }
            if (a%2 == 0){
                TextChet = "четное ";
            }
            else {
                TextChet = "нечетное ";
            }
            System.out.println(TextPlus + TextChet + SlovoChislo);
        }


        //напишите тут ваш код
    }
}
