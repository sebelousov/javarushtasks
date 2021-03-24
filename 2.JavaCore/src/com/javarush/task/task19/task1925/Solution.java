package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            String fileIn = args[0];
            String fileOut = args[1];

            BufferedReader buffer = new BufferedReader(new FileReader(fileIn));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = buffer.readLine()) != null) {
                String[] temp = line.split(" ");
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i].length() > 6) sb.append(temp[i] + ",");
                }
            }
            sb.setLength(sb.length() - 1);
            String str = sb.toString();
            buffer.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));
            writer.write(str);
            writer.close();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Не указаны параметры...");
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл...");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода...");
        }
    }
}
