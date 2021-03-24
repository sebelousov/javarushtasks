package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {

        String link = "finance";
        FileInputStream fis = new FileInputStream(link);

        //напишите тут ваш код
    }

    public static void main(String[] args) {
        try {
            new VeryComplexClass().veryComplexMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
