package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        String fileName = args[1];
        String fileOutputName = args[2];

        switch (args[0]) {
            case "-e":
                try {
                    encode(fileName, fileOutputName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "-d":
                try {
                    decode(fileName, fileOutputName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public static void encode(String fileName, String fileOutputName) throws IOException {
        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(fileName));
        BufferedOutputStream bufferOutput = new BufferedOutputStream(new FileOutputStream(fileOutputName));

        while (buffer.available() > 0) {
            int data = buffer.read() + 1;
            bufferOutput.write(data);
        }

        buffer.close();
        bufferOutput.close();
    }

    public static void decode(String fileName, String fileOutputName) throws IOException {
        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(fileName));
        BufferedOutputStream bufferOutput = new BufferedOutputStream(new FileOutputStream(fileOutputName));

        while (buffer.available() > 0) {
            int data = buffer.read() - 1;
            bufferOutput.write(data);
        }

        buffer.close();
        bufferOutput.close();
    }



}
