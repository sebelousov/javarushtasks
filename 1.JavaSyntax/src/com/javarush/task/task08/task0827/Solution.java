package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date dt = new Date(date);
        SimpleDateFormat dayInYear = new SimpleDateFormat("D");

        int day = Integer.parseInt(dayInYear.format(dt));
        return day%2 != 0;
    }
}
