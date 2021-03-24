package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] charArr = s.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            if (i == 0 || charArr[i - 1] == ' ') charArr[i] = Character.toUpperCase(charArr[i]);
        }

        s = new String(charArr);
        System.out.println(s);
        //напишите тут ваш код
    }
}
