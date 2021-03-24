package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread00());
        threads.add(new Thread01());
        threads.add(new Thread02());
        threads.add(new Thread03());
        threads.add(new Thread04());

    }

    public static void main(String[] args) {


    }


}