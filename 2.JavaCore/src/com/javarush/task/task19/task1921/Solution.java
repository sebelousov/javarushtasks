package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {

        SimpleDateFormat formatter = new SimpleDateFormat("d M yyyy");

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
            String line = null;
            while ((line = buffer.readLine()) != null) {
                String[] temp = line.split(" ");
                StringBuilder human = new StringBuilder(temp[0]);
                human.append(" ");
                for (int i = 1; i < temp.length - 3; i++) {
                    human.append(temp[i]).append(" ");
                }
                human.setLength(human.length() - 1);
                StringBuilder dateInString = new StringBuilder(temp[temp.length - 3] + " " + temp[temp.length - 2] + " " + temp[temp.length - 1]);
                Date date = formatter.parse(dateInString.toString());
                PEOPLE.add(new Person(human.toString(), date));
            }
            buffer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
