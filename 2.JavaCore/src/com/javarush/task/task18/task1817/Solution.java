package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {

        int countAllSymbols = 0;
        int countAllSpaces = 0;
        int index = 100;
        char[] spaces;

        String line = "";

        FileInputStream file = new FileInputStream(args[0]);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            countAllSymbols += line.length();

            spaces = line.toCharArray();
            for (char x : spaces) {
                if (x == ' ') countAllSpaces++;
            }
        }

        scanner.close();
        System.out.printf("%.2f",(double) countAllSpaces / countAllSymbols * index);

//        try {
//            FileInputStream fileInputStream = new FileInputStream(args[0]);
//
//            byte[] bytes = new byte[fileInputStream.available()];
//            fileInputStream.read(bytes, 0, bytes.length);
//
//            for (byte x: bytes) {
//                countAllSymbols++;
//            }
//            System.out.println(countAllSymbols);
//            fileInputStream.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Исходный файл не найден по указанному в параметрах адресу");
//        } catch (IOException e) {
//            System.out.println("Нет доступа к файлу по указанному в параметрах адресу");
//        }
    }
}
