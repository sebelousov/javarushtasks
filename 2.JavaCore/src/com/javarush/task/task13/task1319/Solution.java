package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        String str = "";

        while (true) {
            str = reader.readLine();
            writer.write(str);
            writer.write(System.getProperty("line.separator"));
            if (str.equals("exit")) break;
        }


        reader.close();
        writer.close();

    }
}
