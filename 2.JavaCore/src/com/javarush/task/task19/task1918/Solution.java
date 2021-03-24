package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        try {
            String tag = args[0];
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            while (fileName.isEmpty()) {
                fileName = reader.readLine();
            }
            reader.close();

            BufferedReader buffer = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = buffer.readLine()) != null) {
                sb.append(line);
            }

            buffer.close();

            int start = sb.indexOf("<" + tag, 0);
            int end = sb.indexOf("</" + tag, 0);
            List<String> tags = new ArrayList<>(5);
            List<Integer> starts = new ArrayList<>(5);
            List<Integer> ends = new ArrayList<>(5);

            while (start !=-1) {
                if (start > -1) starts.add(start);
                start += tag.length() + 1;
                if (start >= sb.length() - 1) start = sb.length() - 1;
                start = sb.indexOf("<" + tag, start);
            }

            while (end !=-1) {
                if (end > -1) ends.add(end);
                end += tag.length() + 3;
                if (end >= sb.length() - 1) end = sb.length() - 1;
                end = sb.indexOf("</" + tag, end);
            }

            if (starts.size() != ends.size()) throw new MyException();

            for (int i = 1; i < starts.size(); i++) {
                if (starts.get(i) < ends.get(i - 1)) {
                    int temp = ends.get(i - 1);
                    ends.set(i - 1, ends.get(i));
                    ends.set(i, temp);
                }
            }

            for (int j = 0; j < starts.size(); j++) {
                tags.add(sb.substring(starts.get(j), ends.get(j) + tag.length() + 3));
            }

            for (String x : tags) {
                System.out.println(x);
            }

        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Программа запущена без аргумента, надо запустить программу.");
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
        catch (MyException e) {
            System.out.println("Файл содержит не закрытые теги.");
        }

    }
}

class MyException extends Exception {

}