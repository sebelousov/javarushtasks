package com.javarush.task.task18.task1825;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        try {
            List<String> files = fileNames();
            String finalFileName = finalFileName(files);
            boolean newFile = false;
            Collections.sort(files, new SortWithoutZeroComparator());

            for (int i = 0; i < files.size(); i++) {
                writeBytesToFile(bytesFromFile(files.get(i)), finalFileName, newFile);
                if (i == 0) newFile = true;
            }

        }
        catch (IOException e) {
            System.out.println("Возникла ошибка ввода-вывода");
        }

    }

    public static List<String> fileNames() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> files = new ArrayList<>();
        String fileName = "";
        String end = "end";
        while (!fileName.equals(end)){
            fileName = reader.readLine();
            if (fileName.equals(end)) break;
            files.add(fileName);
        }
        reader.close();
        return files;
    }

    public static byte[] bytesFromFile(String fileName) throws IOException {
        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(fileName), 128);
        byte[] bytes = new byte[buffer.available()];
        buffer.read(bytes, 0, buffer.available());
        buffer.close();
        return bytes;
    }

    public static String finalFileName(List<String> fileNames) {
        boolean finalFileIsExist = false;
        String finalFileName = "";
        for (String x : fileNames) {
            if (finalFileIsExist == false) {
                finalFileName = x.substring(0, x.indexOf(".part"));
                finalFileIsExist = true;
                return finalFileName;
            }
        }
        return finalFileName;
    }

    public static void writeBytesToFile(byte[] bytes, String fileName, boolean newFile) throws IOException {
        BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(fileName, newFile), 128);
        buffer.write(bytes, 0, bytes.length);
        buffer.close();
    }
}

class SortWithoutZeroComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int x = o1.indexOf("part");
        String n = o1.substring((x + 4));
        int n1 = Integer.parseInt(n);
        n = o2.substring((x + 4));
        int n2 = Integer.parseInt(n);

        if (n1 > n2) {
            return 1;
        }
        else if (n1 < n2) {
            return -1;
        }
        else {
            return 0;
        }
    }
}