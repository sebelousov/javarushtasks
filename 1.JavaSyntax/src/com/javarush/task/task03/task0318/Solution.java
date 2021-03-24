package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sAge = reader.readLine();
        String name = reader.readLine();


        String text0 = " захватит мир через ";
        String text1 = " лет. Му-ха-ха!";

        System.out.println(name + text0 + sAge + text1);

        //напишите тут ваш код
    }
}
