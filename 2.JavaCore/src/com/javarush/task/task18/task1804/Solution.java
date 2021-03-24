package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int count = 0;
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        FileInputStream fis = new FileInputStream(scanner.nextLine());
        scanner.close();

        while (fis.available() > 0) {
            numbers.add(fis.read());
        }
        fis.close();

        Collections.sort(numbers);

        int[] counts = new int[numbers.size()];


        for (int i = 0; i < numbers.size(); i++) {
            for (int x : numbers) {
                if (x == numbers.get(i)) count++;

            }
            counts[i] = count;
            count = 0;
        }

        int min = counts[0];

        for (int x : counts) {
            if (x < min) min = x;
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (counts[i] == min && numbers.get(i) != count) {
                System.out.print(numbers.get(i) + " ");
                count = numbers.get(i);
            }
        }
    }
}
