package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int numberFiles = 2;
        String[] fileNames = new String[numberFiles];
        Scanner scanner = new Scanner(System.in);
        List<Integer> datas = new ArrayList<>();

        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = scanner.nextLine();
        }
        scanner.close();

        try {
            FileReader fileReader = new FileReader(fileNames[1]);
            while (fileReader.ready()) {
                datas.add(fileReader.read());
            }
            fileReader.close();

            fileReader = new FileReader(fileNames[0]);

            while (fileReader.ready()) {
                datas.add(fileReader.read());
            }
            fileReader.close();

            FileWriter fileWriter = new FileWriter(fileNames[0], false);

            for (int i = 0; i < datas.size(); i++) {
                fileWriter.write(datas.get(i));
            }

            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
