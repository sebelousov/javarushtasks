package com.javarush.task.task19.task1904;

import javafx.scene.input.DataFormat;

import java.io.File;
import java.io.IOException;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

        File file = new File("data.txt");

        try {
            Scanner scanner = new Scanner(file);
            PersonScannerAdapter adapter = new PersonScannerAdapter(scanner);
            Person person = adapter.read();
            System.out.println(person);

            adapter.close();
        } catch (IOException e) {
            System.out.println("Нет доступа к файлу...");
        }
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {

            String[] s = fileScanner.nextLine().split(" ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");

            try {
                Date date = sdf.parse(s[3] + " " + s[4] + " " + s[5]);
                return new Person(s[1], s[2], s[0], date);
            }
            catch (ParseException e) {
                System.out.println("Ошибка определения даты...");
            }

            return null;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
