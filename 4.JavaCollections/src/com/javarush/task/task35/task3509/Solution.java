package com.javarush.task.task35.task3509;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> list = new ArrayList<>();
        for (Object o : elements) {
            list.add((T) o);
        }
        return list;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet<T> set = new HashSet<>();
        for (T e : elements) {
            set.add(e);
        }
        return set;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        if (keys.size() != values.size()) throw new IllegalArgumentException();

        HashMap<K, V> map = new HashMap<>();
        int count = 0;

        for (K k : keys) {
            map.put(keys.get(count), values.get(count));
            count++;
        }

        return map;
    }
}
