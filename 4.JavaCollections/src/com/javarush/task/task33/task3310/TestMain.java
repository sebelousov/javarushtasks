package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.FileBucket;
import com.javarush.task.task33.task3310.strategy.FileStorageStrategy;

import java.io.IOException;
import java.lang.reflect.Field;

public class TestMain {

    public static void main(String[] args) {
        try {
            FileStorageStrategy strategy = new FileStorageStrategy();

            Field table = strategy.getClass().getDeclaredField("table");
            table.setAccessible(true);
            FileBucket[] buckets = (FileBucket[]) table.get(strategy);

            for (FileBucket fb : buckets) {
                Helper.printMessage(String.valueOf(fb.getFileSize()));
            }

        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            ExceptionHandler.log(e);
        }
    }
}
