package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        FileInputStream fi = new FileInputStream(scanner.nextLine());
        int x = 0, maxByte = 0;

        while (fi.available() > 0) {
            if (x > maxByte) maxByte = x;
            x = fi.read();
        }
        System.out.println(maxByte);

        scanner.close();
        fi.close();
    }
}
