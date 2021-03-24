package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
        List<Integer> numbers = new ArrayList<>();
        int minByte = 0;

        scanner.close();

        while (fileInputStream.available() > 0) {
            numbers.add(fileInputStream.read());
        }

        fileInputStream.close();

        minByte = numbers.get(0);

        for (int num: numbers) {
            if (num < minByte) minByte = num;
        }

        System.out.println(minByte);





    }
}
