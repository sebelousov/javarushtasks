package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[5];
        for (int i = 0; i < list.length; i++){
            list[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(list);
        for (int j = 0; j < list.length; j++){
            System.out.println(list[j]);
        }
        //напишите тут ваш код
    }
}
