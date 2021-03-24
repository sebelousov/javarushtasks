package com.javarush.task.task22.task2212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;

        return telNumber.matches("\\+\\d{12}|\\d{10}|\\+\\d{2,3}\\(\\d{3}\\)\\d{4,7}|\\+\\d{3,8}-\\d{2,3}-\\d{2,3}");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        while (!line.equals("exit")) {
            System.out.println(Solution.checkTelNumber(line));
            line = reader.readLine();
        }
    }
}
