package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String value1 = Helper.generateRandomString();
        String value2 = Helper.generateRandomString();
        String value3 = value1;

        Long key1 = shortener.getId(value1);
        Long key2 = shortener.getId(value2);
        Long key3 = shortener.getId(value3);

        Assert.assertNotEquals("Ошибка, первый ключ равен второму ключу.", key2, key1);
        Assert.assertEquals("Ошибка, первый ключ не равен третему ключу.", key3, key1);

        String value10 = shortener.getString(key1);
        String value20 = shortener.getString(key2);
        String value30 = shortener.getString(key3);

        Assert.assertNotEquals("Ошибка, первый ключ равен второму ключу.", value20, value10);
        Assert.assertEquals("Ошибка, первый ключ не равен третему ключу.", value30, value10);

    }

    @Test
    public void testFileStorageStrategy() {
        try {
            Shortener shortener = new Shortener(new FileStorageStrategy());
            testStorage(shortener);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

}
