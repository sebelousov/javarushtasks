package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        int countFiles = 2;
        String[] fileNames = new String[countFiles];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = scanner.nextLine();
        }

        scanner.close();

        try {
            FileInputStream fileInputStream = new FileInputStream(fileNames[0]);
            FileOutputStream fileOutputStream = new FileOutputStream(fileNames[1]);

            byte[] buffer = new byte[fileInputStream.available()];
            byte[] bufferOut = new byte[buffer.length];
            int n = 0;

            fileInputStream.read(buffer, 0, buffer.length);

            for (int i = buffer.length - 1; i >= 0; i--) {
                bufferOut[n] = buffer[i];
//                System.out.println(buffer[i] + i + bufferOut[n] + n);
                n++;
            }

            fileOutputStream.write(bufferOut, 0, bufferOut.length);

            fileInputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Один из файлов (или оба) не найден");
        } catch (IOException e) {
            System.out.println("Нет доступа к исходному файлу");
        }


    }
}
