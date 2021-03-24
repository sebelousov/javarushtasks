package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String color = "";
        double amountMinutes = WithoutHours(Double.parseDouble(reader.readLine()));

        while (amountMinutes >= 5.0){
            amountMinutes = amountMinutes - 5.0;
        }

        if (amountMinutes >= 0.0 && amountMinutes < 3.0) color = "зеленый";
        if (amountMinutes >= 3.0 && amountMinutes < 4.0) color = "желтый";
        if (amountMinutes >= 4.0 && amountMinutes < 5.0) color = "красный";

        System.out.println(color);

        //напишите тут ваш код
    }

    public static double WithoutHours(double minutes) {

        while (minutes >= 60.0){
            minutes = minutes - 60.0;
        }
        return minutes;

    }
}