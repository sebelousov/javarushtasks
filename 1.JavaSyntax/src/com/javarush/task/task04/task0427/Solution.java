package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        String ChetNeChet = "";
        String t1 = "";
        String ZnachChislo = "значное число";
        String aText = Integer.toString(a);

        if (a >= 1 && a <= 999){
            if (a%2 == 0){
                ChetNeChet = "четное ";
            }
            else {
                ChetNeChet = "нечетное ";
            }
            if (aText.length() == 1) t1 = "одно";
            if (aText.length() == 2) t1 = "дву";
            if (aText.length() == 3) t1 = "трех";
            System.out.println(ChetNeChet + t1 + ZnachChislo);
        }
        else {

        }
        //напишите тут ваш код

    }
}
