package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOut = null;

        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(console);

        String line = outputStream.toString();

        try {
            fileNameOut = reader.readLine();
            while (fileNameOut.isEmpty()) {
                fileNameOut = reader.readLine();
            }
            reader.close();

            FileOutputStream writer = new FileOutputStream(fileNameOut);
            writer.write(line.getBytes());
            System.out.println(line);
            writer.close();
        } catch (IOException e) {
            System.out.println("Empty name of file, please, write name of file again.");
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

