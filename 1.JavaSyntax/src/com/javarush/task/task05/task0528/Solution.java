package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/

public class Solution {
    public static void main(String[] args) {
        Today nowDay = new Today("2018", "07", "16");
        System.out.println(nowDay.day + " " + nowDay.month + " " + nowDay.year);
        //напишите тут ваш код
    }

    public static class Today{
        String year;
        String month;
        String day;
        public Today(String year, String month, String day){
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }
}
