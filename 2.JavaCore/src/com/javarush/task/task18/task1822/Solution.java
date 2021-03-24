package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte[] bytes;
        String[] strings;

        try {
            FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 200);

            bytes = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(bytes, 0, bytes.length);
            strings = new String(bytes, StandardCharsets.UTF_8).split("\\n");

            for (String s : strings) {
                if (s.indexOf(args[0] + " ") == 0) {
                    System.out.println(s);
                }
            }




            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
