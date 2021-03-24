package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);

        testStrategy(new OurHashMapStorageStrategy(), 10000);

        //testStrategy(new FileStorageStrategy(), 100);

        testStrategy(new OurHashBiMapStorageStrategy(), 10000);

        testStrategy(new HashBiMapStorageStrategy(), 10000);

        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> ids = new HashSet<>();
        for (String s : strings) {
            Long id = shortener.getId(s);
            ids.add(id);
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> strings = new HashSet<>();
        for (Long k : keys) {
            String string = shortener.getString(k);
            strings.add(string);
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementNumber) {


        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for (long i = 0; i < elementNumber; i++) {
            String string = Helper.generateRandomString();
            strings.add(string);
        }

        Shortener shortener = new Shortener(strategy);

        Date startDate = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date finishDate = new Date();
        Helper.printMessage(String.valueOf(finishDate.getTime() - startDate.getTime()));

        startDate = new Date();
        Set<String> stringSet = getStrings(shortener, ids);
        finishDate = new Date();
        Helper.printMessage(String.valueOf(finishDate.getTime() - startDate.getTime()));

        if (strings.size() == stringSet.size()) Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
    }
}
