package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        Map<String, String> map = new HashMap<String, String>();
        map.put("January", "1");
        map.put("February", "2");
        map.put("March", "3");
        map.put("April", "4");
        map.put("May", "5");
        map.put("June", "6");
        map.put("July", "7");
        map.put("August", "8");
        map.put("September", "9");
        map.put("October", "10");
        map.put("November", "11");
        map.put("December", "12");

        for (Map.Entry<String, String> pair : map.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (month.toUpperCase().equals(key.toUpperCase())) System.out.println(month + " is the " + value + " month");
        }
    }
}
