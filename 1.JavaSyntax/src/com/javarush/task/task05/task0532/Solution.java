package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int maximum = Integer.parseInt(reader.readLine());

        for (n = n - 1; n > 0; n--){
            int num = Integer.parseInt(reader.readLine());

            if (num > maximum) maximum = num;
        }

        //напишите тут ваш код

        System.out.println(maximum);
    }
}