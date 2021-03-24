package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();

        for (int i = text.length(); i > 0; i--){
            int x = text.charAt(i - 1);
            if (x % 2 > 0){
                odd++;
            }
            else {
                even++;
            }
        }
        System.out.println("Even: " + Integer.toString(even) + " " + "Odd: " + Integer.toString(odd));
        //напишите тут ваш код
    }
}
