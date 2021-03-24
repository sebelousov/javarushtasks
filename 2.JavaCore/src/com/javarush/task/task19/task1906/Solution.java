package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileNameIn = null;
            String fileNameOut = null;
            fileNameIn = reader.readLine();
            fileNameOut = reader.readLine();
            reader.close();

            FileReader fr = new FileReader(fileNameIn);
            FileWriter fw = new FileWriter(fileNameOut);
            boolean key = false;

            while (fr.ready()) {
                int data = fr.read();

                if (key == true) fw.write(data);

                if (key == true) {
                    key = false;
                }
                else {
                    key = true;
                }
            }

            fr.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }


    }
}
