package com.javarush.task.task18.task1823;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String exit = "exit";
        String fileName;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            fileName = scanner.nextLine();
            if (fileName.equals(exit)) break;
            new ReadThread(fileName).start();
        }

        scanner.close();

    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                BufferedInputStream buffer = new BufferedInputStream(fileInputStream, 64);
                byte[] bytes = new byte[buffer.available()];
                buffer.read(bytes, 0, bytes.length);
                buffer.close();

                int maxByte = bytes[0];
                int minByte = bytes[0];

                for (byte x : bytes) {
                    if (x > maxByte) maxByte = x;
                    if (x < minByte) minByte = x;
                }

                if (minByte < 0) minByte = minByte * -1;

                int[] numbers00 = new int[maxByte + 1];
                int[] numbers01 = new int[minByte + 1];

                for (int x : bytes) {
                    if (x >= 0) {
                        numbers00[x] = numbers00[x] + 1;
                    }
                    else {
                        x = x * -1;
                        numbers01[x] = numbers01[x] + 1;
                    }
                }

                int max = numbers00[0];
                int cutterntValue = 0;

                for (int i = 0; i < numbers00.length; i++) {
                    if (numbers00[i] > max) {
                        max = numbers00[i];
                        cutterntValue = i;
                    }
                }

                for (int j = 0; j < numbers01.length; j++) {
                    if (numbers01[j] > max) {
                        max = numbers01[j];
                        cutterntValue = j * -1;
                    }
                }

                resultMap.put(fileName, cutterntValue);


            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
            } catch (IOException e) {
                System.out.println("Нет доступа к файлу");
            }

        }
    }
}
