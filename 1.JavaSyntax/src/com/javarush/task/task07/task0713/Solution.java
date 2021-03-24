package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list00 = new ArrayList<Integer>();
        ArrayList<Integer> list01 = new ArrayList<Integer>();
        ArrayList<Integer> list02 = new ArrayList<Integer>();
        ArrayList<Integer> list03 = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number;

        for (int i = 0; i < 20; i++){
            number = Integer.parseInt(reader.readLine());
            list00.add(number);
            if (number % 3 == 0) {
                list01.add(number);
            }
            if (number % 2 == 0) list02.add(number);
            if (number % 3 != 0 && number % 2 != 0) list03.add(number);
        }

        printList(list01);
        printList(list02);
        printList(list03);


        //напишите тут ваш код
    }

    public static void printList(List<Integer> list) {
        for (int j = 0; j < list.size(); j++){
            System.out.println(list.get(j));
        }
        //напишите тут ваш код
    }
}
