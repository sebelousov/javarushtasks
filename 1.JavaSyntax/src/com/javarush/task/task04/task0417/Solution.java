package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        String text = "";

        if (a == b && a == c){
            System.out.println(Integer.toString(a) + " " + Integer.toString(b) + " " + Integer.toString(c));
        }
        else {
            if (a == b) System.out.println(Integer.toString(a) + " " + Integer.toString(b));
            if (a == c) System.out.println(Integer.toString(a) + " " + Integer.toString(c));
            if (b == c) System.out.println(Integer.toString(b) + " " + Integer.toString(c));
        }



        //напишите тут ваш код
    }
}