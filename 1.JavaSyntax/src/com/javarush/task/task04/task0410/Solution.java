package com.javarush.task.task04.task0410;

/* 
Попадём-не-попадём
*/

public class Solution {
    public static void main(String[] args) {
        checkInterval(60);
        checkInterval(112);
        checkInterval(10);
    }

    public static void checkInterval(int a) {

        String text0 = "Число ";
        String text1 = "не ";
        String text2 = "содержится в интервале.";

        if (a >= 50 && a <= 100){
            text0 = text0 + Integer.toString(a) + " " + text2;
        }
        else {
            text0 = text0 + Integer.toString(a) + " " + text1 + text2;
        }

        System.out.println(text0);
        //напишите тут ваш код
    }
}