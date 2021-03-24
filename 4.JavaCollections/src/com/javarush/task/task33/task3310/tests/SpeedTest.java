package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long timeToGetIds;
        Date startDate = new Date();

        for (String s : strings) {
            Long id = shortener.getId(s);
            ids.add(id);
        }

        Date endDate = new Date();
        timeToGetIds = endDate.getTime() - startDate.getTime();

        return timeToGetIds;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long timeToGetStrings;
        Date startDate = new Date();

        for (Long id : ids) {
            String string = shortener.getString(id);
            strings.add(string);
        }

        Date endDate = new Date();
        timeToGetStrings = endDate.getTime() - startDate.getTime();

        return timeToGetStrings;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        Set<String> strings1 = new HashSet<>();
        Set<String> strings2 = new HashSet<>();
        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();


        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        long timeToGetIds1 = getTimeToGetIds(shortener1, origStrings, ids1);
        long timeToGetIds2 = getTimeToGetIds(shortener2, origStrings, ids2);

        Assert.assertTrue(timeToGetIds2 < timeToGetIds1);

        long timeToGetStrings1 = getTimeToGetStrings(shortener1, ids1, strings1);
        long timeToGetStrings2 = getTimeToGetStrings(shortener2, ids2, strings2);
        
        Assert.assertEquals(timeToGetStrings2, timeToGetStrings1, 45);
    }
}
