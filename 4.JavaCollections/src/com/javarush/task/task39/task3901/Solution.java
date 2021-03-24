package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        Set<String> substrings = new HashSet<>();
        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            substrings.add(s.substring(i));
        }

        for (int i = s.length(); i >= 0; i--) {
            substrings.add(s.substring(0, i));
        }

        for (String e : substrings) {
            Set<Character> letters = new HashSet<>();
            char[] chars = e.toCharArray();

            for (char c : chars) {
                letters.add(c);
            }

            if (e.length() == letters.size()) sizes.add(letters.size());
        }

        return Collections.max(sizes);
    }
}
