package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        List<Person> addresses = new ArrayList<Person>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) break;
            String family = reader.readLine();
            addresses.add(new Person(city, family));
        }

        //read home number
        String city2 = reader.readLine();

        for (Person person : addresses) {
            if (person.getCity().equals(city2)) System.out.println(person.getFamily());
        }

    }

    static class Person {
        private String city;
        private String family;

        public Person(String city, String family) {
            this.city = city;
            this.family = family;
        }

        public String getCity() {
            return city;
        }

        public String getFamily() {
            return family;
        }
    }
}
