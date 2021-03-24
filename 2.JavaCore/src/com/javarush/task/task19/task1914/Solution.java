package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        String line = outputStream.toString();
        System.setOut(consoleStream);

        String[] task = line.split("(\\s)|(\\s[=]\\s)");
        int result;

        if (task[1].equals("+")) {
            result = Integer.parseInt(task[0]) + Integer.parseInt(task[2]);
        }
        else if (task[1].equals("-")) {
            result = Integer.parseInt(task[0]) - Integer.parseInt(task[2]);
        }
        else if (task[1].equals("*")) {
            result = Integer.parseInt(task[0]) * Integer.parseInt(task[2]);
        }
        else {
            result = Integer.parseInt(task[0]) / Integer.parseInt(task[2]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < task.length; i++) {
            sb.append(task[i]).append(" ");
        }
        sb.append(result);
        System.out.println(sb.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

