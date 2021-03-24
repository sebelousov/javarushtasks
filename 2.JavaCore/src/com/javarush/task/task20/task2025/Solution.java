package com.javarush.task.task20.task2025;

/* 
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        long number = 9223372036854775807L;
        while (number != 0) {
            number--;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] s1 = {
                "1234",
                "4123",
                "3412",
                "2341"
        };

        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i].hashCode());
        }
    }
}
