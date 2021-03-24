package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        String y = reader.readLine();
        String m = reader.readLine();
        String d = reader.readLine();
        String text0 = ".";
        String text1 = "Меня зовут ";
        String text2 = "Я родился ";

        System.out.println(text1 + name + text0);
        System.out.println(text2 + d + text0 + m + text0 + y);

        //напишите тут ваш код
    }
}
