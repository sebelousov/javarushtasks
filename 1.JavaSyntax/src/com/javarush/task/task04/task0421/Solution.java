package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name00 = reader.readLine();
        String name01 = reader.readLine();

        if (name00.equals(name01) == true){
            System.out.println("Имена идентичны");
        }
        else {
            if (name00.length() == name01.length()){
                System.out.println("Длины имен равны");
            }
            else {

            }
        }
    }
}
