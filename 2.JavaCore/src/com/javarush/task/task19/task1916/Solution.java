package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] namesFiles = new String[2];

        try {
            for (int i = 0; i < namesFiles.length; i++) {
                namesFiles[i] = reader.readLine();
                while (namesFiles[i].isEmpty()) {
                    namesFiles[i] = reader.readLine();
                }
            }
            reader.close();
        }
        catch (IOException e) {
            System.out.println("Name of file is empty...");
        }

        try {
            List<String> list00 = fileToArray(namesFiles[0]);
            List<String> list01 = fileToArray(namesFiles[1]);

            int i = 0;
            int j = 0;

            while (i < list00.size() && j < list01.size()) {
                if (list00.get(i).equals(list01.get(j))) {
                    System.out.println("same - " + i + " - " + j);
                    lines.add(new LineItem(Type.SAME, list00.get(i)));
                    i++;
                    j++;
                }
                else {
                    if (i == list00.size() - 1 || j == list01.size() - 1) {
                        if (list00.get(i).equals(list01.get(j - 1))) {
                            lines.add(new LineItem(Type.ADDED, list01.get(j)));
                            j++;
                        }
                        else if (list00.get(i - 1).equals(list01.get(j))) {
                            lines.add(new LineItem(Type.REMOVED, list00.get(i)));
                            i++;
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        if (list00.get(i).equals(list01.get(j + 1))) {
                            lines.add(new LineItem(Type.ADDED, list01.get(j)));
                            j++;
                        }
                        else if (list00.get(i + 1).equals(list01.get(j))) {
                            lines.add(new LineItem(Type.REMOVED, list00.get(i)));
                            i++;
                        }
                        else {
                            System.out.println("Something is wrong...");
                        }
                    }
                }
            }

            if (list00.size() < list01.size()) {
                while (j < list01.size()) {
                    lines.add(new LineItem(Type.ADDED, list01.get(j)));
                    j++;
                }
            }
            else {
                while (i < list00.size()) {
                    lines.add(new LineItem(Type.REMOVED, list00.get(i)));
                    i++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not found...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (LineItem x : lines) {
            System.out.println(x);
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return "LineItem{" +
                    "type=" + type +
                    ", line='" + line + '\'' +
                    '}';
        }
    }

    public static List<String> fileToArray(String fileName) throws FileNotFoundException, IOException {
        BufferedReader buffer = new BufferedReader(new FileReader(fileName));
        List<String> list = new ArrayList<>();
        String line = null;
        while ((line = buffer.readLine()) != null) {
            list.add(line);
        }
        buffer.close();
        return list;
    }
}
