package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();


        while (true) {
            if (str.equals("exit")) {
                break;
            }
            else {
                if (str.indexOf(".") > 0) {
                    if (isDouble(str)) {
                        print(Double.parseDouble(str));
                    }
                    else {
                        print(str);
                    }
                }
                else {
                    if (isNumber(str)) {
                        int y = Integer.parseInt(str);
                        System.out.println(str);
                        if (y <= 0 || y >= 128) {
                            print(y);
                            System.out.println("---");
                        }
                        else if (y > 0 || y < 128) {
                            print((short) y);
                        }
                    }
                    else {
                        print(str);
                    }
                }
            }
            str = reader.readLine();
        }



    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }

    public static boolean isDouble(String s) {
        try {
            double d = Double.parseDouble(s);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isNumber(String s) {
        try {
            int x = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isShort(String s) {
        try {
            short x = Short.parseShort(s);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


}
