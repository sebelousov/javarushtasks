package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
                if (fileInputStream.available() < 1000) {
                    scanner.close();
                    fileInputStream.close();
                    throw new DownloadException();
                }

            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
            } catch (IOException e) {
                System.out.println("Файл недоступен");
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
