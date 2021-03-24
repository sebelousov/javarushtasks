package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
        solution.createExpression(18);
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        if (number == 0 || number > 3000) return;

        StringBuilder out = new StringBuilder(number + " =");
        int[] numbers = {
                1, 3, 9, 27,
                81, 243, 729, 2187};
        int temp = 0;

        // 1 3 9 27 81 243 729 2187
        for (int i = 0; i < numbers.length; i++) {
            int balance = number % 3 + temp;
            if (balance == 3) {
                temp = 1;
            }
            if (balance == 2) {
                temp = 1;
                out.append(" - ").append(numbers[i]);
            }
            if (balance == 1) {
                temp = 0;
                out.append(" + ").append(numbers[i]);
            }
            if (balance == 0) {
                temp = 0;
            }
            number /= 3;
        }
        System.out.println(out.toString());

    }
}