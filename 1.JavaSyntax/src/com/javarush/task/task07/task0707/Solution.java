package com.javarush.task.task07.task0707;

import java.util.ArrayList;
import java.util.Collections;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "one", "two", "three", "four", "five");

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        //напишите тут ваш код
    }
}
