package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        if (s == null || s.isEmpty()) return 0;

        char[] chars = s.toLowerCase().toCharArray();
        int outNumber = 0;

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'i':
                    if ((i + 1) != chars.length && chars[i + 1] == 'v') {
                        outNumber += 4;
                        i++;
                    }
                    else if ((i + 1) != chars.length && chars[i + 1] == 'x') {
                        outNumber += 9;
                        i++;
                    }
                    else {
                        outNumber++;
                    }
                    break;
                case 'v':
                    outNumber += 5;
                    break;
                case 'x':
                    if ((i + 1) != chars.length && chars[i + 1] == 'l') {
                        outNumber += 40;
                        i++;
                    }
                    else {
                        outNumber += 10;
                    }
                    break;
                case 'l':
                    outNumber += 50;
                    break;
                case 'c':
                    if ((i + 1) != chars.length && chars[i + 1] == 'm') {
                        outNumber += 900;
                        i++;
                    }
                    else if ((i + 1) != chars.length && chars[i + 1] == 'd') {
                        outNumber += 400;
                        i++;
                    }
                    else {
                        outNumber += 100;
                    }
                    break;
                case 'd':
                    outNumber += 500;
                    break;
                case 'm':
                    outNumber += 1000;
                    break;
            }
        }

        return outNumber;
    }
}
