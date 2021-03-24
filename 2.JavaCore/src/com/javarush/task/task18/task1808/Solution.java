package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        int countFiles = 3;

        System.out.println("Последовательно введите три имени файла, каждое с новой строки...");
        String[] fileNames = readFileNames(countFiles);

        try {
            FileInputStream fileInputStream = new FileInputStream(fileNames[0]);
            FileOutputStream fileOutputStream = new FileOutputStream(fileNames[1]);
            FileOutputStream fileOutputStream2 = new FileOutputStream(fileNames[2]);

            if (fileInputStream.available() >  0) {
                int count = fileInputStream.available();
                byte[] buffer = new byte[count];

                if (count % 2 == 0) {
                    byte[] buffer00 = new byte[count / 2];
                    byte[] buffer01 = new byte[count / 2];
                    fileInputStream.read(buffer00, 0, buffer00.length);
                    fileInputStream.read(buffer01, 0, buffer01.length);

                    fileOutputStream.write(buffer00, 0, buffer00.length);
                    fileOutputStream2.write(buffer01, 0, buffer01.length);
                }
                else {
                    byte[] buffer00 = new byte[count / 2 + 1];
                    byte[] buffer01 = new byte[count / 2];
                    fileInputStream.read(buffer00, 0, buffer00.length);
                    fileInputStream.read(buffer01, 0, buffer01.length);

                    fileOutputStream.write(buffer00, 0, buffer00.length);
                    fileOutputStream2.write(buffer01, 0, buffer01.length);
                }
            }
            else {
                System.out.println("Исходный файл пустой");
            }

            fileInputStream.close();
            fileOutputStream.close();
            fileOutputStream2.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Третье исключение");
        }
    }

    public static String[] readFileNames(int n) {
        Scanner scanner = new Scanner(System.in);
        String[] fileNames = new String[n];

        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = scanner.nextLine();
        }
        scanner.close();
        return fileNames;
    }
}
