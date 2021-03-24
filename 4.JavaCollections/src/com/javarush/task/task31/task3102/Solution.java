package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileList = Files.walk(Paths.get(root)).filter(path -> path.toFile().isFile()).map(p -> p.toString()).collect(Collectors.toList());
        return fileList;
    }

    public static void main(String[] args) {
        String root = "D:" + File.separator + "video" + File.separator + "java-books";
        try {
            getFileTree(root).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
