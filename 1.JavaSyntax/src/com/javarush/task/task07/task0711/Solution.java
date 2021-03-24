package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String lastString;
        int n;

        for (int i = 0; i < 5; i++){
            strings.add(reader.readLine());
        }
        n = strings.size() - 1;

        for (int j = 0; j < 13; j++){
            lastString = strings.get(n);
            strings.remove(n);
            strings.add(0, lastString);
        }

        for (int m = 0; m < 5; m++){
            System.out.println(strings.get(m));
        }
        //напишите тут ваш код
    }
}
