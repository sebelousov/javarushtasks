package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array = {13, 8, 18, 15, 5, 17};
        sort(array);
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        int medianaOfArray;
        Arrays.sort(array);

        if (array.length % 2 == 0) {
            medianaOfArray = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
        }
        else {
            medianaOfArray = array[array.length / 2];
        }

        Comparator<Integer> compareByInteger = (o1, o2) -> {
            int t1;
            int t2;
            t1 = Math.abs(o1 - medianaOfArray);
            t2 = Math.abs(o2 - medianaOfArray);
            if (t1 == t2) {
                return o1 - o2;
            }

            return t1 - t2;
        };

        Arrays.sort(array, compareByInteger);

        return array;
    }
}
