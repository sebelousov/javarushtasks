package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int year = abs(Integer.parseInt(reader.readLine()));
        String text = "количество дней в году: ";

        System.out.println(text + Integer.toSring(daysInYear(year)));
        //напишите тут ваш код
    }

    public static int daysInYear(int year) {

        int days;

        if ((year%4) == 0){
            if ((year%400) == 0){
                days = 366;
            }
            else {
                days = 365;
            }
        }
        else {
            days = 365;
        }
        return days;
    }

    public static int abs(int a) {
        if (a > 0){
            return a;
        }
        else {
            return -a;
        }
    }
}