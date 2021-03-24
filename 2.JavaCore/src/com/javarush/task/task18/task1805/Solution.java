package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        FileInputStream fis = new FileInputStream(scanner.nextLine());
        scanner.close();
        List<Integer> bytes = new ArrayList<>();
        int max = 0;
        
        while (fis.available() > 0) {
            bytes.add(fis.read());
        }
        
        fis.close();
        
        for (int x: bytes) {
            if (x > max) max = x;
//            System.out.println(x);
        }

//        System.out.println("---");
//        System.out.println(max);

        int[] index = new int[max];
        for (int x: bytes) {
            index[x - 1] = x;
        }

        for (int y : index){
            if (y != 0) System.out.print(y + " ");
        }
        
    }
}
