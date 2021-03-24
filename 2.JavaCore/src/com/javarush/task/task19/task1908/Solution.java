package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameIn = null;
        String fileNameOut = null;

        try {
            fileNameIn = reader.readLine();
            while (fileNameIn.isEmpty()) {
                fileNameIn = reader.readLine();
            }

            fileNameOut = reader.readLine();
            while (fileNameOut.isEmpty()) {
                fileNameOut = reader.readLine();
            }
            reader.close();

            BufferedReader buffer = new BufferedReader(new FileReader(fileNameIn));

            String line;
            ArrayList<String> numbers = new ArrayList<>(10);

            while ((line = buffer.readLine()) != null) {
                String[] words = line.split("[ ,.!?]");

                for (String x : words) {
                    if (isNumeric(x)) numbers.add(x);
                }
                words = null;
            }
            buffer.close();

            StringBuffer str = new StringBuffer();

            for (String x : numbers) {
                str.append(x).append(" ");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOut));

            writer.write(str.toString());

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
        } catch (IOException e) {
            System.out.println("You need to write name of file...");
        }

    }

    public static boolean isNumeric(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
