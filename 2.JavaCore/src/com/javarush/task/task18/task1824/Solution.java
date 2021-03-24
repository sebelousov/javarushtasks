package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String fileName = scanner.nextLine();
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                break;
            } catch (IOException e) {
                System.out.println("Нет доступа к файлу");
            }
        }



    }
}
