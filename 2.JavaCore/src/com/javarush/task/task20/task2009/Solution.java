package com.javarush.task.task20.task2009;

import java.io.*;
import java.util.Objects;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        transient public static String staticString = "This is a static test string";
        public int i;
        public int j;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ClassWithStatic that = (ClassWithStatic) o;
            return i == that.i &&
                    j == that.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public static void main(String[] args) {
        ClassWithStatic classWithStatic = new ClassWithStatic();

        try {
            String fileName = "data.bin";
            OutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(classWithStatic);

            InputStream inputStream = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(inputStream);

            ClassWithStatic loadObject = (ClassWithStatic) ois.readObject();
            System.out.println(classWithStatic.equals(loadObject));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
