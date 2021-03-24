package com.javarush.task.task40.task4008;

/* 
Работа с Java 8 DateTime API
*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        printDate("9.10.2017 5:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        if (date == null) throw new IllegalArgumentException();


        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("d.M.yyyy");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("H:m:s");


        if (date.contains(":") && date.contains(".")) {
            int temp = date.indexOf(" ");
            LocalDate parseDate = LocalDate.parse(date.substring(0, temp), formatterDate);
            LocalTime parseTime = LocalTime.parse(date.substring(temp + 1), formatterTime);

            System.out.println("День: " + parseDate.getDayOfMonth());
            System.out.println("День недели: " + parseDate.get(ChronoField.DAY_OF_WEEK));
            System.out.println("День месяца: " + parseDate.get(ChronoField.DAY_OF_MONTH));
            System.out.println("День года: " + parseDate.getDayOfYear());
            System.out.println("Неделя месяца: " + parseDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
            System.out.println("Неделя года: " + parseDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
            System.out.println("Месяц: " + parseDate.get(ChronoField.MONTH_OF_YEAR));
            System.out.println("Год: " + parseDate.get(ChronoField.YEAR));

            System.out.println("AM или PM: " + (parseTime.get(ChronoField.AMPM_OF_DAY) == 1 ? "PM" : "AM"));
            System.out.println("Часы: " + parseTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));
            System.out.println("Часы дня: " + parseTime.get(ChronoField.HOUR_OF_DAY));
            System.out.println("Минуты: " + parseTime.getMinute());
            System.out.println("Секунды: " + parseTime.getSecond());
        }
        else if (date.contains(":")) {
            LocalTime parseTime = LocalTime.parse(date, formatterTime);
            System.out.println("AM или PM: " + (parseTime.get(ChronoField.AMPM_OF_DAY) == 1 ? "PM" : "AM"));
            System.out.println("Часы: " + parseTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));
            System.out.println("Часы дня: " + parseTime.get(ChronoField.HOUR_OF_DAY));
            System.out.println("Минуты: " + parseTime.getMinute());
            System.out.println("Секунды: " + parseTime.getSecond());
        }
        else if (date.contains(".")) {
            LocalDate parseDate = LocalDate.parse(date, formatterDate);
            System.out.println("День: " + parseDate.getDayOfMonth());
            System.out.println("День недели: " + parseDate.get(ChronoField.DAY_OF_WEEK));
            System.out.println("День месяца: " + parseDate.get(ChronoField.DAY_OF_MONTH));
            System.out.println("День года: " + parseDate.getDayOfYear());
            System.out.println("Неделя месяца: " + parseDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
            System.out.println("Неделя года: " + parseDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
            System.out.println("Месяц: " + parseDate.get(ChronoField.MONTH_OF_YEAR));
            System.out.println("Год: " + parseDate.get(ChronoField.YEAR));
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
