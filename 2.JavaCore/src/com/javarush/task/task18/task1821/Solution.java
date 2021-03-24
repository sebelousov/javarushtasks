package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        BufferedInputStream buffer = new BufferedInputStream(fileInputStream, 200);

        char currentSymbol;
        int[] index = new int[128];

        while (buffer.available() > 0) {
            currentSymbol = (char) buffer.read();
            index[(int) currentSymbol]++;
        }

        for (int i = 0; i < index.length; i++) {
            if (index[i] != 0) System.out.println((char) i + " " + index[i]);
        }

        buffer.close();
    }
}
