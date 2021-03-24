package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {

        Map<String, Double> map = new TreeMap<>();

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
            String line = null;
            while ((line = buffer.readLine()) != null) {
                String[] temp = line.split(" ");
                if (map.containsKey(temp[0])) {
                    Double currentNumber = map.get(temp[0]) + Double.parseDouble(temp[1]);
                    map.put(temp[0], currentNumber);
                }
                else {
                    map.put(temp[0], Double.parseDouble(temp[1]));
                }
            }
            buffer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        double max = 0.0;
        List<String> names = new ArrayList<>();

        for (Map.Entry<String, Double> x : map.entrySet()) {
            double temp = (double) x.getValue();
            if (temp >= max) {
                max = temp;
            }
        }

        for (Map.Entry<String, Double> x : map.entrySet()) {
            if (x.getValue() == max) {
                names.add(x.getKey());
            }
        }

        for (String y : names) {
            System.out.println(y);
        }

    }
}
