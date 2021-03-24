package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine().replace(" ", "");
        ArrayList<Character> vowels1 = new ArrayList<Character>();
        ArrayList<Character> notVowels = new ArrayList<Character>();

        for (int i = 0; i < text.length(); i++) {
            if (isVowel(text.charAt(i)) == true) {
                vowels1.add(text.charAt(i));
            }
            else {
                notVowels.add(text.charAt(i));
            }
        }

        for (int j = 0; j < vowels1.size(); j++) {
            System.out.print(vowels1.get(j) + " ");
        }
        System.out.println();
        for (int n = 0; n < notVowels.size(); n++) {
            System.out.print(notVowels.get(n) + " ");
        }
        //напишите тут ваш код
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}