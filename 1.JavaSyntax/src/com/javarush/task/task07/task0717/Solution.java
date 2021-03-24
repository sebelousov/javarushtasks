package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countOfStrings = 10;

        for (int i = 0; i < countOfStrings; i++) {
            list.add(reader.readLine());
        }

        ArrayList<String> result = doubleValues(list);
        for (int m = 0; m < result.size(); m++) {
            System.out.println(result.get(m));
        }
        // Вывести на экран result
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        ArrayList<String> listDouble = new ArrayList<String>();
        int multi = 2;
        for (int j = 0; j < list.size(); j++) {
            for (int n = 0; n < multi; n++) {
                listDouble.add(list.get(j));
            }
        }
        //напишите тут ваш код
        return listDouble;
    }
}
