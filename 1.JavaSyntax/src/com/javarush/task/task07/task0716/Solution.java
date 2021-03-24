package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        String word00;
        int n = 2; //Количество строк, содержащих л
        ArrayList<String> list1 = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            word00 = list.get(i);

            if (word00.indexOf("р") == -1 && word00.indexOf("л") == -1) {
                list1.add(word00);
            }
            else {
                if (word00.indexOf("р") != -1) {
                    if (word00.indexOf("р") != -1 && word00.indexOf("л") != -1) {
                        list1.add(word00);
                    }
                    else {

                    }
                }
                else {
                    if (word00.indexOf("р") != -1 && word00.indexOf("л") != -1) {
                        list1.add(word00);
                    }
                    else {
                        for (int j = 0; j < n; j++) {
                            list1.add(word00);
                        }
                    }
                }
            }
        }
        //напишите тут ваш код
        return list1;
    }
}