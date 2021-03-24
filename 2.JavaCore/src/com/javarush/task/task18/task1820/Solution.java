package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        int numberFiles = 2;
        String[] namesFiles = new String[numberFiles];
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < namesFiles.length; i++) {
            namesFiles[i] = scanner.nextLine();
        }

        scanner.close();

        FileInputStream fileInputStream = new FileInputStream(namesFiles[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(namesFiles[1]);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes, 0, bytes.length);
        fileInputStream.close();

        String[] numbers = new String(bytes, StandardCharsets.UTF_8).split(" ");

        for (int i = 0; i < numbers.length; i++) {
            sb.append(Math.round(Double.parseDouble(numbers[i])));
            if (i < numbers.length - 1) sb.append(" ");
        }

        fileOutputStream.write(sb.toString().getBytes());
        fileOutputStream.close();
    }
}
