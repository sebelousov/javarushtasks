package com.javarush.task.task17.task1721;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws CorruptedDataException {

        Scanner scanner = new Scanner(System.in);
        String[] namesFiles = new String[2];

        for (int i = 0; i < namesFiles.length; i++) {
            System.out.println("Введите имя файла...");
            namesFiles[i] = scanner.nextLine();
        }

        scanner.close();

        File file00 = new File(namesFiles[0]);
        File file01 = new File(namesFiles[1]);

        try {
            Scanner scannerFiles = new Scanner(file00);
            while (scannerFiles.hasNextLine()) {
                allLines.add(scannerFiles.nextLine());
            }
            scannerFiles.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Исходный файл не найден...");
        }

        try {
            Scanner scannerFiles = new Scanner(file01);
            while (scannerFiles.hasNextLine()) {
                forRemoveLines.add(scannerFiles.nextLine());
            }
            scannerFiles.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Второй файл не найден...");
        }

        new Solution().joinData();
    }

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            for (int i = 0; i < forRemoveLines.size(); i++) {
                while (allLines.contains(forRemoveLines.get(i))) {
                    allLines.remove(forRemoveLines.get(i));
                }
            }
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
