package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double sr = 0.0;
        double x = 0.0;
        int y = 0;

        while (true){
            x = 1.0 * Integer.parseInt(reader.readLine());
            if (x == -1){
                break;
            }
            else {
                sr = sr + x;
                y++;
            }

        }
        sr = sr / y;
        System.out.println(sr);
        //напишите тут ваш код
    }
}

