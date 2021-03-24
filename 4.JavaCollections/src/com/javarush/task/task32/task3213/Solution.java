package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader == null) return "";
        BufferedReader buffer = new BufferedReader(reader);
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int number = (int) chars[i] + key;
                chars[i] = (char) number;
            }

            sb.append(new String(chars));
        }


        return sb.toString();
    }
}
