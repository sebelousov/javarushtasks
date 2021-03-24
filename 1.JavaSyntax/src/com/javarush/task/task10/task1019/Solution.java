package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        while (true) {
            String idInString = reader.readLine();
            if (idInString.isEmpty()) break;

            String name = reader.readLine();
            if (name.isEmpty()) {
                int id = Integer.parseInt(idInString);
                map.put("", id);
                break;
            }
            else {
                int id = Integer.parseInt(idInString);
                map.put(name, id);
            }
        }

        for (HashMap.Entry<String, Integer> pair : map.entrySet()) {
            String key = pair.getKey(); // name
            Integer value = pair.getValue(); // id

            if (key.equals("zero")) {
                System.out.println(key);
            }
            else {
                System.out.println(value + " " + key);
            }
        }
    }
}
