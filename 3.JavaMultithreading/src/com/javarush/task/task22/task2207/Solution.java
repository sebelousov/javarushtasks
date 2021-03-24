package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        while (fileName.isEmpty()) {
            fileName = reader.readLine();
        }

        reader.close();

        BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        List<String> words = new LinkedList<>();
        String line = null;

        while ((line = buffer.readLine()) != null) {
            String[] tmp = line.split(" ");
            for (String x : tmp) {
                words.add(x);
            }
            tmp = null;
        }
        buffer.close();

        while (!words.isEmpty()) {
            StringBuilder sb = new StringBuilder();;
            String first = words.get(0);
            String second = null;
            String tmp = sb.append(first).reverse().toString();
            sb = null;
            while (words.contains(first) || words.contains(tmp)) {
                words.remove(first);
                if (words.contains(tmp)) {
                    words.remove(tmp);
                    second = tmp;
                }
            }

            if (second != null) result.add(new Pair(first, second));
            first = null;
            second = null;
        }

        for (Pair x : result) {
            System.out.println(x.getFirst() + " : " + x.getSecond());
        }



    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
            this.first = "no words";
            this.second = "no words";
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }

        public void setFirst(String first) {
            this.first = first;
        }

        public void setSecond(String second) {
            this.second = second;
        }

        public String getFirst() {
            return first;
        }

        public String getSecond() {
            return second;
        }
    }

}
