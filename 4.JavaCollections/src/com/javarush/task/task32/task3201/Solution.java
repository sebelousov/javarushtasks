package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        if (args.length < 3) {
            System.out.println("No params...");
            return;
        }

        String fileName = args[0];
        long number = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            if (number >= raf.length()) {
                raf.seek(raf.length());

            }
            else {
                raf.seek(number);
            }
            raf.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
