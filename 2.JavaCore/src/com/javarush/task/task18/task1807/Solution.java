package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte b = (byte) ',';
        int count = 0;


        try (FileInputStream fileInputStream = new FileInputStream(scanner.nextLine())) {

            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                if (data == b) count++;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Не найден файл...");
        } catch (IOException e) {
            System.out.println("Неверно указано имя файла...");
        }

        System.out.println(count);
        scanner.close();
    }
}
