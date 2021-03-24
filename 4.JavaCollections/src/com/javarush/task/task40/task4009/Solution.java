package com.javarush.task.task40.task4009;

/* 
Buon Compleanno!
*/

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
        System.out.println(getWeekdayOfBirthday("1.12.2015", "2016"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        //напишите тут ваш код
        if (
                birthday == null ||
                year == null ||
                birthday.isEmpty() ||
                year.isEmpty()
        ) throw new IllegalArgumentException();


        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy", Locale.ITALIAN);
            LocalDate parseDate = LocalDate.parse(birthday, formatter);

            LocalDate newDate = parseDate.plusYears(Year.parse(year).getValue() - parseDate.getYear());
            return newDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN).toLowerCase();
        }
        catch (Exception e) {
            System.out.println("Wrong year...");
        }

        return null;
    }
}
