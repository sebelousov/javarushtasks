package com.javarush.task.task31.task3109;

import java.io.*;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName))) {
            Properties properties = new Properties();

            if (fileName.endsWith(".xml")) properties.loadFromXML(inputStream);
            else properties.load(inputStream);

            return properties;
        } catch (IOException e) {
            return new Properties();
        }
    }
}
