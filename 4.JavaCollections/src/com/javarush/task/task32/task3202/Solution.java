package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("D:\\video\\java-books\\1\\data.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        if (is == null) return new StringWriter();
        try (BufferedInputStream reader = new BufferedInputStream(is)){
            byte[] bytes = new byte[reader.available()];
            reader.read(bytes);
            StringWriter writer = new StringWriter();
            writer.write(new String(bytes));
            return writer;
        }
    }
}