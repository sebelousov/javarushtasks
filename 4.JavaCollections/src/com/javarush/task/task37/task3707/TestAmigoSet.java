package com.javarush.task.task37.task3707;

import java.io.*;

public class TestAmigoSet {
    public static void main(String[] args) {
        AmigoSet<Integer> set = new AmigoSet<>();

        for (int i = 0; i < 5; i++) {
            if (set.add(i)) System.out.println("Добавлено - " + i);
        }

        System.out.println("Set is completed...");

        try {
            FileOutputStream fos = new FileOutputStream("setamigo.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(set);
            oos.flush();
            fos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("setamigo.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            AmigoSet<Integer> copySet = (AmigoSet<Integer>) ois.readObject();
            ois.close();

            for (Object e : copySet) {
                System.out.println(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
