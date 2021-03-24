package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String nameFileIn = null;
        try {
            nameFileIn = reader.readLine();
            while (nameFileIn.isEmpty()) {
                nameFileIn = reader.readLine();
            }

            String nameFileOut = reader.readLine();
            while (nameFileOut.isEmpty()) {
                nameFileOut = reader.readLine();
            }

            reader.close();

            BufferedReader buffer = new BufferedReader(new FileReader(nameFileIn));
            BufferedWriter writer = new BufferedWriter(new FileWriter(nameFileOut));

            String line = null;

            while ((line = buffer.readLine()) != null) {
                writer.write(line.replace('.', '!'));
                writer.newLine();
            }

            buffer.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Один из файлов не найден");
        } catch (IOException e) {
            System.out.println("Введено пустое поле вместо имени файла");
        }


    }
}
