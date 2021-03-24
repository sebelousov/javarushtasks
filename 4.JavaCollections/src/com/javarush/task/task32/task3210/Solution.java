package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String... args) {
        if (args.length < 3) return;


        String fileName = args[0];
        long number = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")){
            raf.seek(number);
            byte[] bytes = new byte[text.length()];
            raf.read(bytes, 0, text.length());
            String textFromFile = new String(bytes);

            raf.seek(raf.length());
            if (text.equals(textFromFile)) raf.write("true".getBytes());
            else raf.write("false".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
