package com.javarush.task.task04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {

        System.out.println(Solution.checkSeason0(month));


        //напишите тут ваш код
    }

    public static String checkSeason0(int month) {
        String season;

        if (month == 12 || month <= 2){
            season = "зима";
        }
        else {
            if (month >= 3 && month <= 5){
                season = "весна";
            }
            else{
                if (month >= 6 && month <= 8){
                    season = "лето";
                }
                else {
                    season = "осень";
                }
            }

        }
        return season;
    }
}