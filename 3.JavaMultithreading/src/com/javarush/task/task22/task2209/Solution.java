package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        while (fileName.isEmpty()) {
            fileName = reader.readLine();
        }
        reader.close();

        BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        ArrayList<String> towns = new ArrayList<>();
        String line = null;
        while ((line = buffer.readLine()) != null) {
            String[] tmp = line.split(" ");
            for (int i = 0; i < tmp.length; i++) {
                towns.add(tmp[i]);
            }
        }

        String[] strings = new String[towns.size()];

        StringBuilder result = getLine(towns.toArray(strings));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) return new StringBuilder();
        if (words.length == 1 || words[0].equals("")) return new StringBuilder(words[0]);

        StringBuilder sb = new StringBuilder();
        List<String> cities = new LinkedList<>(Arrays.asList(words));
        List<String> result = new ArrayList<>(words.length);

        while (cities.remove("")) {
            cities.remove("");
        }

        String tmp = cities.get(3);
        int last = tmp.toLowerCase().charAt(tmp.length() - 1);
        int i = 0;
        sb.append(tmp).append(" ");
        cities.remove(3);

        while (!cities.isEmpty()) {
            String tmp01 = cities.get(i);
            int first = tmp01.toLowerCase().charAt(0);
            if (first == last) {
                last = tmp01.toLowerCase().charAt(tmp01.length() - 1);
                result.add(tmp01);
                cities.remove(i);
                i = -1;
            }
            i++;
            if (i == cities.size() + 1) i = 0;
        }

        for (int j = 0; j < result.size(); j++) {
            sb.append(result.get(j)).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb;
    }
}
