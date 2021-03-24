package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>();
        ArrayList<Integer> lengthOfStrings = new ArrayList<Integer>();
        String oneString;
        int min, max;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++){
            oneString = reader.readLine();
            strings.add(oneString);
            lengthOfStrings.add(oneString.length());
        }

        max = lengthOfStrings.get(0);
        min = lengthOfStrings.get(0);

        for (int j = 0; j < strings.size(); j++){
            if (lengthOfStrings.get(j) > max) max = lengthOfStrings.get(j);
            if (lengthOfStrings.get(j) < min) min = lengthOfStrings.get(j);
        }

        for (int n = 0; n < lengthOfStrings.size(); n++){
            if (lengthOfStrings.get(n) == min) {
                System.out.println(strings.get(n));
                break;
            }
            if (lengthOfStrings.get(n) == max) {
                System.out.println(strings.get(n));
                break;
            }

        }
        //напишите тут ваш код
    }
}
