package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = "world";
        try {
            String fileName = reader.readLine();
            while (fileName.isEmpty()) {
                fileName = reader.readLine();
            }
            reader.close();
            FileReader fr = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(fr);
            String line;
            byte count = 0;
            int temp = 0;
            while ((line = buffer.readLine()) != null) {
                String[] words = line.split("[ ,.!?-]");
                for (String x : words) {
                    if (x.equals(word)) count++;
                }
                words = null;
            }
            buffer.close();
            System.out.println(count);
        } catch (IOException e) {
            System.out.println("Введено некорректное имя файла");
        }

    }
}
