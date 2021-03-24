package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        String fileName = null;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            while (fileName.isEmpty()) {
                fileName = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(fileName));
            String line = null;

            while ((line = buffer.readLine()) != null) {
                StringBuilder sb = new StringBuilder(line);
                System.out.println(sb.reverse().toString());
            }

            buffer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
