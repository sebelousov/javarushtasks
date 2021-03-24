package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {




        try {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            int count = 0;
            if (fileInputStream.available() > 0) {
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer, 0 , buffer.length);

                for (byte x : buffer) {
                    if ((x >= 65 && x <= 90) || (x >= 97 && x <= 122)) count++;
                }
                System.out.println(count);
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Имя файла указано некорректно");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}
