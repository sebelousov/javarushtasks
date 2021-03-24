package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countOfString = 5;
        int elementToDelete = 2;

        for (int i = 0; i < countOfString; i++){
            list.add(reader.readLine());
        }

        list.remove(elementToDelete);

        for (int j = countOfString - 2; j > -1; j--){
            System.out.println(list.get(j));
        }
        //напишите тут ваш код
    }
}


