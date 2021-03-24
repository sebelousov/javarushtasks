package com.javarush.task.task39.task3909;

import java.util.Arrays;

/*
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway(
                "01",
                "102"));
    }

    public static boolean isOneEditAway(String first, String second) {
        if (
                first == null
                || second == null
                || Math.abs(first.length() - second.length()) > 1
                ) return false;

        if (
                first.equals(second)
                || first.isEmpty()
                || second.isEmpty()
                ) return true;

        int mistakes = 0;

        // Substitution
        // Insertion
        // Deletion

        if (first.length() == second.length()) {
            char[] charsFirst = first.toCharArray();
            char[] charsSecond = second.toCharArray();

            for (int i = 0; i < charsFirst.length; i++) {
                if (charsFirst[i] != charsSecond[i]) {
                    mistakes++;
                    if (mistakes > 1) return false;
                }
            }
        }
        else {
            char[] charsFirst = first.length() > second.length() ? first.toCharArray() : second.toCharArray();
            char[] charsSecond = first.length() < second.length() ? first.toCharArray() : second.toCharArray();
            int lengthLongArray = charsFirst.length;
            int lengthShortArray = charsSecond.length;

            int i = 0;
            int j = 0;

            while (i < lengthLongArray) {
                //System.out.println(charsFirst[i] + " - " + charsSecond[j]);
                if (charsFirst[i] != charsSecond[j]) {
                    mistakes++;

                    if (charsFirst[i + 1] != charsSecond[j] || charsFirst[i] != charsSecond[j + 1]) mistakes++;

                    if (mistakes > 1) return false;
                }
                i++;
                j++;
                if (j == lengthShortArray) break;
            }
        }

        return true;
    }
}
