package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

        InputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        if (outputStream == null) throw new Exception();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        Properties prop = new Properties();

        prop.putAll(properties);
        prop.store(writer, "18:16");

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        if (inputStream == null) throw new Exception();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
        Properties prop = new Properties();
        prop.load(buffer);

        for (Map.Entry<Object, Object> pair : prop.entrySet()) {
            properties.put((String) pair.getKey(), (String) pair.getValue());
        }

        buffer.close();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        try {
            solution.fillInPropertiesMap();
            Thread.sleep(3000);
            OutputStream outputStream = new FileOutputStream("data01.properties");
            solution.save(outputStream);

            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
