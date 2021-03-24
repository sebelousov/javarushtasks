package com.javarush.task.task22.task2203;

import java.util.StringTokenizer;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || !string.matches("^.*\t.*\t.*$")) throw new TooShortStringException();

        String[] words = string.split("\t");

        return words[1];
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));

    }
}
