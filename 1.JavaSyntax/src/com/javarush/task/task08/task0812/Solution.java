package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int countsOfNumbers = 10;
        int countsOfRepeat0 = 1;
        int countsOfRepeat1 = 1;
        int oldNumber = 0;

        for (int i = 0; i < countsOfNumbers; i++) {
            numbers.add(Integer.parseInt(reader.readLine()));

        }
        oldNumber = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (oldNumber == numbers.get(i)) {
                countsOfRepeat0++;
                if (countsOfRepeat1 < countsOfRepeat0) {
                    countsOfRepeat1 = countsOfRepeat0;
                }
            }
            else {
                if (countsOfRepeat1 < countsOfRepeat0) {
                    countsOfRepeat1 = countsOfRepeat0;
                }
                countsOfRepeat0 = 1;
            }
            oldNumber = numbers.get(i);
        }

        System.out.println(countsOfRepeat1);

    }
}