package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int numbersFiles = 3;
        String[] files = new String[numbersFiles];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < files.length; i++) {
            files[i] = scanner.nextLine();
        }
        scanner.close();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(files[0]);
            FileInputStream fileInputStream00 = new FileInputStream(files[1]);
            FileInputStream fileInputStream01 = new FileInputStream(files[2]);

            if (fileInputStream00.available() > 0 && fileInputStream01.available() > 0) {
                byte[] buffer00 = new byte[fileInputStream00.available()];
                byte[] buffer01 = new byte[fileInputStream01.available()];

                fileInputStream00.read(buffer00, 0, buffer00.length);
                fileInputStream01.read(buffer01, 0, buffer01.length);

                fileOutputStream.write(buffer00, 0, buffer00.length);
                fileOutputStream.write(buffer01, 0, buffer01.length);

            }

            fileOutputStream.close();
            fileInputStream00.close();
            fileInputStream01.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (String x : files) {
//            System.out.println(x);
//        }
    }
}
