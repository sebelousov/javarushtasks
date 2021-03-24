package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int x = 0;
        int y = 0;
        int z = 0;

        if (a >= b && a >= c) {
            x = a;
            if (b >= c){
                y = b;
                z = c;
            }
            else {
                y = c;
                z = b;
            }
        }

        if (b >= a && b >= c) {
            x = b;
            if (a >= c){
                y = a;
                z = c;
            }
            else {
                y = c;
                z = a;
            }
        }

        if (c >= a && c >= b) {
            x = c;
            if (a >= b){
                y = a;
                z = b;
            }
            else {
                y = b;
                z = a;
            }
        }


        System.out.println(Integer.toString(x) + " " + Integer.toString(y) + " " + Integer.toString(z));
        //напишите тут ваш код
    }
}
