package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String param;
        int count;

        try {
            param = reader.readLine();
            if (param.equals("helicopter")) {
                result = new Helicopter();
            }
            else if (param.equals("plane")) {

                try {
                    param = reader.readLine();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                count = Integer.parseInt(param);
                result = new Plane(count);
            }
            else {

            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }





    }
}
