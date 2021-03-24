package com.javarush.task.task07.task0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Вывести числа в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        int countOfStrings = 10;

        for (int i = 0; i < countOfStrings; i++){
            list.add(Integer.parseInt(reader.readLine()));
        }

        for (int j = list.size() - 1; j > -1; j--){
            System.out.println(list.get(j));
        }
        //напишите тут ваш код
    }
}
