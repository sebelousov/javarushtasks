package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        String count = "8";

        for (; m > 0; m--){
            for (int i = n - 1; i > 0; i--){
                System.out.print(count);
            }
            System.out.println(count);
        }
        //напишите тут ваш код

    }
}
