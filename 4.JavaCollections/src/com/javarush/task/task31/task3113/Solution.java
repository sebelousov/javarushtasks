package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path dir = Paths.get(reader.readLine());

        if (Files.isDirectory(dir)) {
            final int[] numberOfDirectories = {0};
            final int[] numberOfFiles = {0};
            final long[] size = {0};

            Files.walk(dir).forEach(path -> {
                if (Files.isDirectory(path)) numberOfDirectories[0]++;
                if (Files.isRegularFile(path)) {
                    numberOfFiles[0]++;
                    try {
                        size[0] += Files.size(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            System.out.println("Всего папок - " + (numberOfDirectories[0] - 1));
            System.out.println("Всего файлов - " + numberOfFiles[0]);
            System.out.println("Общий размер - " + size[0]);
        }
        else {
            System.out.println(dir.toString() + " - не папка");
        }
    }
}
