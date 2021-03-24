package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 10;
        int lengthString;
        String firstString;
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < count; i++) {
            list.add(reader.readLine());
        }

        firstString = list.get(0);
        lengthString = firstString.length();

        for (int j = 0; j < list.size(); j++) {
            firstString = list.get(j);
            if (lengthString > firstString.length()) {
                lengthString = firstString.length();
                System.out.println(j);
                break;
            }
            lengthString = firstString.length();
        }

        //напишите тут ваш код
    }
}

