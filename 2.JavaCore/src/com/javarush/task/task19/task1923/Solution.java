package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {

        // file00 file01
        try {
            String fileIn = args[0];
            String fileOut = args[1];

            BufferedReader buffer = new BufferedReader(new FileReader(fileIn));
            StringBuilder wordsWithDigits = new StringBuilder();
            String pattern = ".*\\d+.*";
            String line = null;
            while ((line = buffer.readLine()) != null) {
                String[] temp = line.split(" ");
                for (String x : temp) {
                    if (x.matches(pattern)) wordsWithDigits.append(x).append(" ");
                }
            }
            buffer.close();
            wordsWithDigits.setLength(wordsWithDigits.length() - 1);

            BufferedWriter out = new BufferedWriter(new FileWriter(fileOut));
            String outStr = wordsWithDigits.toString();
            out.write(outStr);
            out.close();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Нет параметров...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
