package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        while (fileName.isEmpty()) {
            fileName = reader.readLine();
        }
        reader.close();

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = buffer.readLine()) != null) {
                String[] temp = line.split(" ");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < temp.length; i++) {
                    int digit = isDigit(temp[i]);
                    if (map.containsKey(digit)) {
                        if (digit != -1) temp[i] = map.get(digit);
                    }
                }

                for (String x : temp) {
                    sb.append(x + " ");
                }
                sb.setLength(sb.length() - 1);
                System.out.println(sb.toString());
            }

            buffer.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден...");
        }

    }

    public static int isDigit(String s) {
        try {
            int num = Integer.parseInt(s);
            return num;
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }
}
