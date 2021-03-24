package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int dayNumber = Integer.parseInt(reader.readLine());

        System.out.println(WeekDay(dayNumber));

        //напишите тут ваш код
    }

    public static String WeekDay(int dayNumber) {

        String text = "такого дня недели не существует";


        //if (dayNumber < 0 || dayNumber > 7) text = "";

        if (dayNumber == 1) text = "понедельник";
        if (dayNumber == 2) text = "вторник";
        if (dayNumber == 3) text = "среда";
        if (dayNumber == 4) text = "четверг";
        if (dayNumber == 5) text = "пятница";
        if (dayNumber == 6) text = "суббота";
        if (dayNumber == 7) text = "воскресенье";

        return text;
    }

}