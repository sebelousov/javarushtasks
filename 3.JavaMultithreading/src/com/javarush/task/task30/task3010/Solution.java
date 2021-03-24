package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            if (args.length == 0) {
                System.out.println("incorrect");
                return;
            }
            if (!isCorrectString(args[0])) {
                System.out.println("incorrect");
                return;
            }
            else {
                System.out.println(getMinRadix(args[0]));
            }
        }
        catch (Exception e) {

        }



    }

    private static boolean isCorrectString(String s) {
        char[] symbols = s.toUpperCase().toCharArray();
        for (char c : symbols) {
            if ((int) c < 48 || ((int) c > 57 && (int) c < 65) || (int) c > 90) {
                return false;
            }
        }
        return true;
    }

    private static Integer getMinRadix(String s) {

        for (int i = 2; i <= 36; i++) {
            try {
                BigInteger number = new BigInteger(s, i);
                return i;
            }
            catch (NumberFormatException e) {

            }
        }
        return -1;
    }
}