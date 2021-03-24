package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Thread04 extends Thread {

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        String r = "";

        while (true) {
            try {
                r = reader.readLine();
                if (r.equals("N")) {
                    System.out.println(sum);
                    break;
                }
                sum += Integer.parseInt(r);
            }
            catch (IOException e) {

            }
        }
    }
}
