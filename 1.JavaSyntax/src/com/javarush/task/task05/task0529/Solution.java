package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        while (true){
            String num = reader.readLine();
            if (num.equals("сумма")){
                break;
            }
            sum = sum + Integer.parseInt(num);
        }
        System.out.println(sum);

        //напишите тут ваш код
    }
}
