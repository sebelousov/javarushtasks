package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] strings = {"мама", "мыла", "раму"};
        String wordImenno = "именно";

        ArrayList<String> strings1 = new ArrayList<String>();

        for (int i = 0; i < strings.length; i++){
            strings1.add(strings[i]);
            strings1.add(wordImenno);
        }

        for (int j = 0; j < strings1.size(); j++){
            System.out.println(strings1.get(j));
        }
        //напишите тут ваш код
    }
}
