package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("No param...");
            return;
        }

        Set<Character> set = new TreeSet<>();
        String fileName = args[0];

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(fileName))))) {
            String line = null;
            while ((line = buffer.readLine()) != null) {
                char[] chars = line.toLowerCase().toCharArray();
                for (char c : chars) {
                    if ((int) c > 96 && (int) c < 123) {
                        set.add(c);
                    }
                }
            }
        }

        if (set.size() >= 5) {
            int score = 0;
            for (Character c : set) {
                System.out.print(c);
                score++;
                if (score == 5) break;
            }
        }
        else {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next());
            }
        }
    }
}
