package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    private static void createHuman(String name, String sex, Date bd) {
        if (sex.equals("ж")){
            allPeople.add(Person.createFemale(name, bd));
        }
        else {
            allPeople.add(Person.createMale(name, bd));
        }
        System.out.println(allPeople.size() - 1);
    }

    private static void updateHuman(Person person, String name, String sex, Date bd) {
        person.setName(name);

        if (sex.equals("ж")) {
            person.setSex(Sex.FEMALE);
        }
        else {
            person.setSex(Sex.MALE);
        }
        person.setBirthDate(bd);

    }

    private static void deleteHuman(Person person) {
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
        //System.out.println(person.getName());
    }

    private static void informHuman(Person person) {
        String name = person.getName();
        String sex;
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        if (person.getSex() == Sex.MALE) {
            sex = "м";
        }
        else {
            sex = "ж";
        }

        System.out.println(name + " " + sex + " " + dateFormat1.format(person.getBirthDate()));
    }



    public static void main(String[] args) throws ParseException {
        //start here - начни тут

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        //String arg = args[0];
        int id;
        String name;
        String sex;
        Date bd;
        Person person;

        if (args[0].equals("-c")) {
            name = args[1];
            sex =  args[2];
            bd = dateFormat.parse(args[3]);

            createHuman(name, sex, bd);
        }
        else if (args[0].equals("-u")) {
            id = Integer.parseInt(args[1]);
            name = args[2];
            sex = args[3];
            bd = dateFormat.parse(args[4]);
            person = allPeople.get(id);
            updateHuman(person, name, sex, bd);
        }
        else if (args[0].equals("-d")) {
            id = Integer.parseInt(args[1]);
            person = allPeople.get(id);

            deleteHuman(person);
        }
        else if (args[0].equals("-i")) {
            id = Integer.parseInt(args[1]);
            person = allPeople.get(id);

            informHuman(person);
        }
        else {
            System.out.println("Опять нет вариантов...");
        }





    }
}
