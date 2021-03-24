package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(getFileName())));
        ArrayList<Integer> numInString = new ArrayList<Integer>();
        String line;
        int x;

        while (reader.ready()) {
            line = reader.readLine();
            x = Integer.parseInt(line);
            if (x%2 == 0) numInString.add(x);
        }

        reader.close();

        Collections.sort(numInString);

        for (int i = 0; i < numInString.size(); i++) {
            System.out.println(numInString.get(i));
        }

    }

    static String getFileName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        if (fileName.isEmpty()) fileName = "Не указано имя файла";
        reader.close();
        return fileName;
    }

    static int[] getSortNum(int[] num) {
        int temp;
        for (int i = 0; i < num.length; i++) {
            for (int j = 1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
        return num;
    }
}
