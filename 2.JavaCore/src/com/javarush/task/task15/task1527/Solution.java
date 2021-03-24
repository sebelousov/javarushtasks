package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = null;

        try {
            url = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }



        String[] paramsAndValues = url.substring(url.indexOf('?') + 1).split("&");
        String[] params = new String[paramsAndValues.length];
        String[] values = new String[paramsAndValues.length];
        String[] temp = new String[2];


        for (int i = 0; i < paramsAndValues.length; i++) {
            if (paramsAndValues[i].indexOf('=') == -1) {
                params[i] = paramsAndValues[i];
                values[i] = "novalue";
            }
            else {
                temp = paramsAndValues[i].split("=");
                params[i] = temp[0];
                values[i] = temp[1];
            }
        }

        for (int i = 0; i < params.length; i++) {
            System.out.print(params[i] + " ");
        }

        for (int i = 0; i < params.length; i++) {
            if (params[i].equals("obj")) {
                try {
                    alert(Double.parseDouble(values[i]));
                }
                catch (Exception e) {
                    alert(values[i]);
                }
                /*if (values[i].indexOf('.') > -1) {
                    alert(Double.parseDouble(values[i]));
                }
                else {
                    alert(values[i]);
                }*/
            }
        }




    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
