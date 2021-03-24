package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String fileNameIn = reader.readLine();
            while (fileNameIn.isEmpty()) {
                fileNameIn = reader.readLine();
            }

            String fileNameOut = reader.readLine();
            while (fileNameOut.isEmpty()) {
                fileNameOut = reader.readLine();
            }
            reader.close();

            BufferedReader buffer = new BufferedReader(new FileReader(fileNameIn));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOut));

            String line = null;

            while ((line = buffer.readLine()) != null) {
                writer.write(line.replaceAll("\\p{Punct}", ""));
            }

            buffer.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
