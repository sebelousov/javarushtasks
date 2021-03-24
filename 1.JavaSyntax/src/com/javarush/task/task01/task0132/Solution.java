package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {

        int hundred;
        int decade;
        int numbers;
        int sum;

        hundred = number / 100;
        number = number - hundred * 100;
        decade = number / 10;
        numbers = number - decade * 10;

        sum = hundred + decade + numbers;
        return sum;

        number = number / 10;



        //напишите тут ваш код
    }
}