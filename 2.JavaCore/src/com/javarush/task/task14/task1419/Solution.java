package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new NullPointerException();
        }
        catch (NullPointerException r) {
            exceptions.add(r);
        }

        try {
            throw new FileNotFoundException();
        }
        catch (FileNotFoundException r) {
            exceptions.add(r);
        }

        try {
            throw new RuntimeException();
        }
        catch (RuntimeException r) {
            exceptions.add(r);
        }

        try {
            throw new IndexOutOfBoundsException();
        }
        catch (IndexOutOfBoundsException r) {
            exceptions.add(r);
        }

        try {
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException r) {
            exceptions.add(r);
        }

        try {
            throw new NumberFormatException();
        }
        catch (NumberFormatException r) {
            exceptions.add(r);
        }

        try {
            throw new ArrayIndexOutOfBoundsException();
        }
        catch (ArrayIndexOutOfBoundsException r) {
            exceptions.add(r);
        }

        try {
            throw new StringIndexOutOfBoundsException();
        }
        catch (StringIndexOutOfBoundsException r) {
            exceptions.add(r);
        }

        try {
            throw new NegativeArraySizeException();
        }
        catch (NegativeArraySizeException r) {
            exceptions.add(r);
        }

        /*try {
            throw new OutOfMemoryError();
        }
        catch (OutOfMemoryError r) {
            exceptions.add(r);
        }*/


    }
}
