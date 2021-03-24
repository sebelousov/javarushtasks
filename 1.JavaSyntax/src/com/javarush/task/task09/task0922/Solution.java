package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date todayDateInNewFormat = formatDate.parse(reader.readLine());

        SimpleDateFormat formatDate1 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(formatDate1.format(todayDateInNewFormat).toUpperCase());
        //напишите тут ваш код
    }
}
