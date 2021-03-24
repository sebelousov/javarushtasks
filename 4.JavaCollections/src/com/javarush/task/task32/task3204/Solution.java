package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Random random = new Random();
        // digits
        for (int i = 0; i < 3; i++) {
            stream.write(48 + random.nextInt(10));
        }

        // lower letters
        for (int i = 0; i < 3; i++) {
            stream.write(65 + random.nextInt(26));
        }

        // capital letters
        for (int i = 0; i < 2; i++) {
            stream.write(97 + random.nextInt(26));
        }
        return stream;
    }
}