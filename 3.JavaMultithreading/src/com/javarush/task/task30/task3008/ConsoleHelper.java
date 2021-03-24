package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        boolean isString = false;
        String string = "";
        while (!isString) {
            try {
                string = reader.readLine();
                isString = true;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return string;
    }

    public static int readInt() {
        boolean isNumber = false;
        int number = -1;
        while (!isNumber) {
            try {
                number = Integer.parseInt(readString());
                isNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return number;
    }
}
