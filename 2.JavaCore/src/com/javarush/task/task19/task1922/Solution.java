package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String fileName = reader.readLine();

            while (fileName.isEmpty()) {
                fileName = reader.readLine();
            }
            reader.close();

            BufferedReader buffer = new BufferedReader(new FileReader(fileName));
            String line = null;

            while ((line = buffer.readLine()) != null) {
                int count = 0;

                for (String x : words) {
                    Pattern pattern = Pattern.compile("\\b" + x + "\\b");
                    Matcher matcher = pattern.matcher(line);

                    while (matcher.find()) {
                        count++;
                    }
                }
                if (count == 2) System.out.println(line);
            }

            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
