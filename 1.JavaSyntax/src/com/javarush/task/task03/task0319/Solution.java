package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        String amountMoney = reader.readLine();
        String amountYears = reader.readLine();
        String text00 = " получает ";
        String text01 = " через ";
        String text02 = " лет.";

        System.out.println(name + text00 + amountMoney + text01 + amountYears + text02);

        //напишите тут ваш код
    }
}
