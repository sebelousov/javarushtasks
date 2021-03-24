package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.*;

/* 
Самые частые байты
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

        int[] index = new int[numbers.size()];
        int[] counts = new int[numbers.size()];


        for (int i = 0; i < numbers.size(); i++) {
            for (int x : numbers) {
                if (x == numbers.get(i)) count++;

            }
            counts[i] = count;
            count = 0;
        }

        int max = counts[0];

        for (int x : counts) {
            if (x > max) max = x;
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (counts[i] == max && numbers.get(i) != count) {
                System.out.print(numbers.get(i) + " ");
                count = numbers.get(i);
            }
        }
    }
}
