package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.lang.Integer;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        //int x = 20; //Количество чисел в коллекции
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(20);
        set.add(21);
        set.add(22);
        set.add(15);
        set.add(16);
        set.add(17);
        set.add(18);
        set.add(19);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(45);
        set.add(46);
        set.add(47);
        set.add(48);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            int x = iter.next();
            if (x > 10) iter.remove();
        }

        return set;
    }

    public static void main(String[] args) {

    }
}
