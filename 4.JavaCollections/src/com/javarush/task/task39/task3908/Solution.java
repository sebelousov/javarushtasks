package com.javarush.task.task39.task3908;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("aabbcc"));
    }

    public static boolean isPalindromePermutation(String s) {
        if (s == null) return false;
        List<Integer> amount = new ArrayList<>();
        Set<Character> letters = new HashSet<>();
        char[] chars = s
                //.replaceAll("[^a-zA-Zа-яА-Я]", "")
                .toLowerCase()
                .toCharArray();

        for (char e : chars) letters.add(e);

        for (char c : letters) {
            amount.add(amountChar(chars, c));
        }

        if (chars.length % 2 == 0) {
            for (Integer e : amount) {
                if (e % 2 != 0) return false;
            }
        }
        else {
            int temp = 0;
            for (Integer e : amount) {
                if (e % 2 != 0) temp++;
            }

            if (!(temp == 1)) return false;
        }

        return true;
    }

    public static int amountChar(char[] chars, char c) {
        int counter = 0;
        for (char e : chars) {
            if (e == c) counter++;
        }
        return counter;
    }
}
