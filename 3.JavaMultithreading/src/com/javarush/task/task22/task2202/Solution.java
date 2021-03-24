package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
        System.out.println(getPartOfString("Амиго"));

//        for (String x : getPartOfString("JavaRush - лучший сервис обучения Java.")) {
//            System.out.println(x);
//        }

    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();

        String[] words = string.split(" ");
        StringBuilder sb = new StringBuilder();

        if (words.length < 5) {
            throw new TooShortStringException();
        }
        else {
            for (int i = 1; i < 5; i++) {
                sb.append(words[i]);
                if (i < 4) sb.append(" ");
            }
            return sb.toString();
        }
    }

    public static class TooShortStringException extends RuntimeException {

    }
}
