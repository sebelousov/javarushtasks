package com.javarush.task.task03.task0312;

/* 
Конвертируем время
*/

public class Solution {
    public static int convertToSeconds(int h) {
        int s = 3600;
        int sh;

        sh = s * h;
        return sh;

    }
    //напишите тут ваш код

    public static void main(String[] args) {

        System.out.println(convertToSeconds(3));
        System.out.println(convertToSeconds(5));

        //напишите тут ваш код
    }


}
