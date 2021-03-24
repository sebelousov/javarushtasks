package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.0, "Строчка 1");
        labels.put(2.0, "Строчка 2");
        labels.put(3.0, "Строчка 3");
        labels.put(4.5, "Строчка 4");
        labels.put(5.1, "Строчка 5");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
