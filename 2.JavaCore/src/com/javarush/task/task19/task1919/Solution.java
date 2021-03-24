package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

        for (Map.Entry<String, Double> x : map.entrySet()) {
            System.out.format("%s %s\n", x.getKey(), x.getValue());
        }

    }
}
