package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        try {
            while (true) {
                numbers.add(Integer.parseInt(reader.readLine()));
            }
        }
        catch (Exception e) {
            for (int i = 0; i < numbers.size(); i++) {
                System.out.println(numbers.get(i));
            }
        }
        //напишите тут ваш код
    }
}
