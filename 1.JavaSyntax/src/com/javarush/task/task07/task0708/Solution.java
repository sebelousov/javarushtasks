package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<String>();
        ArrayList<Integer> maxLengthStringCount = new ArrayList<Integer>();
        String stringCurrent;
        int max;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++){
            stringCurrent = reader.readLine();
            strings.add(stringCurrent);
            maxLengthStringCount.add(stringCurrent.length());
        }

        max = maxLengthStringCount.get(0);

        for (int j = 0; j < maxLengthStringCount.size(); j++){
            if (maxLengthStringCount.get(j) > max) max = maxLengthStringCount.get(j);
        }

        for (int n = 0; n < maxLengthStringCount.size(); n++){
            if (maxLengthStringCount.get(n) == max) System.out.println(strings.get(n));
        }

        //напишите тут ваш код
    }
}
