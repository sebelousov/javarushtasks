package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String a1 = reader.readLine();
        int a = Integer.parseInt(a1);
        String b1 = reader.readLine();
        int b = Integer.parseInt(b1);
        String c1 = reader.readLine();
        int c = Integer.parseInt(c1);

        String answer;






        if (a < (b + c) && b < (a + c) && c < (a + b)){
            answer = "Треугольник существует.";
        }
        else {
            answer = "Треугольник не существует.";
        }

        System.out.println(answer);

        //напишите тут ваш код
    }
}