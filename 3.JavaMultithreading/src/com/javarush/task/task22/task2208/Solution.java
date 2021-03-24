package com.javarush.task.task22.task2208;

import java.util.*;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", "17");

        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        if (params == null) return "No map";
        String string00 = "%s = '%s'";
        String string01 = " and ";
        List<String> strings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (key == null || value == null) {

            }
            else {
                strings.add(String.format(string00, key, value));
            }
        }

        for (String x : strings) {
            if (x.matches("^name.*")) sb.append(x).append(string01);
        }


        for (int i = 0; i < strings.size(); i++) {
            if (!strings.get(i).matches("^name.*")) {
                sb.append(strings.get(i));
                if (i < strings.size() - 1) sb.append(string01);
            }
        }

        return sb.toString();
    }
}
