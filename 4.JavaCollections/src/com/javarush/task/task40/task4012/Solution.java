package com.javarush.task.task40.task4012;

import java.time.*;
import java.time.temporal.ChronoUnit;

/* 
Полезные методы DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isLeap(LocalDate.now()));
        System.out.println(isLeap(LocalDate.of(2019, 10, 5)));

        System.out.println(isBefore(LocalDateTime.of(2020, 10, 5, 15, 10, 36)));

        System.out.println(addTime(LocalTime.now(), 10, ChronoUnit.MINUTES));

        System.out.println(getPeriodBetween(
                LocalDate.of(2015, 6, 1),
                LocalDate.of(2020, 5, 10)));

        System.out.println(getPeriodBetween(
                LocalDate.of(2015, 6, 1),
                LocalDate.of(2020, 5, 10)
        ));

        System.out.println(getPeriodBetween(
                LocalDate.of(2020, 5, 10),
                LocalDate.of(2015, 6, 1)
        ));
    }

    public static boolean isLeap(LocalDate date) {
        return date.isLeapYear();
    }

    public static boolean isBefore(LocalDateTime dateTime) {
        LocalDateTime now = LocalDateTime.now();
        return dateTime.isBefore(now);
    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
        return time.plus(n, chronoUnit);
    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate.isBefore(secondDate)) return Period.between(firstDate, secondDate);
        if (secondDate.isBefore(firstDate)) return Period.between(secondDate, firstDate);
        return Period.ZERO;
    }
}
