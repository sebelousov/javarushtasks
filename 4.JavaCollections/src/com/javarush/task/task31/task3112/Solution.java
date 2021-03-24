package com.javarush.task.task31.task3112;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/video"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        File fileResult = new File(new File(downloadDirectory.toString()), url.getFile());
        InputStream in = url.openStream();
        Path temp = Files.createTempFile(null, ".tmp");

        Files.copy(in, temp);

        Files.move(temp, Paths.get(fileResult.getAbsolutePath()));

        return Paths.get(fileResult.getAbsolutePath());
        // implement this method
    }
}
