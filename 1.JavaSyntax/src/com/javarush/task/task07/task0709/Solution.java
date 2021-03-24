package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> lengthOfWords = new ArrayList<Integer>();
        String oneWord;
        int min;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++){
            oneWord = reader.readLine();
            words.add(oneWord);
            lengthOfWords.add(oneWord.length());
        }

        min = lengthOfWords.get(0);

        for (int j = 0; j < lengthOfWords.size(); j++){
            if (lengthOfWords.get(j) < min) min = lengthOfWords.get(j);
        }

        for (int n = 0; n < lengthOfWords.size(); n++){
            if (lengthOfWords.get(n) == min) System.out.println(words.get(n));
        }
        //напишите тут ваш код
    }
}
