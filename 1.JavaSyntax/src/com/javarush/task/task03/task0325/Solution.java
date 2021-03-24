package com.javarush.task.task03.task0325;

import java.io.*;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String n = reader.readLine();

        String text0 = "Я буду зарабатывать $";
        String text1 = " в час";

        System.out.println(text0 + n + text1);
        //напишите тут ваш код
    }
}
