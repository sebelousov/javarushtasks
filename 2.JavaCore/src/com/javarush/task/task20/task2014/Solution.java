package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));

        String fileName = "data.bin";
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));

            Solution savedObject = new Solution(20);
            out.writeObject(savedObject);

            Solution loadedObject = (Solution) in.readObject();

            System.out.println(savedObject.string.equals(loadedObject.string));

            in.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return string.equals(solution.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }
}
