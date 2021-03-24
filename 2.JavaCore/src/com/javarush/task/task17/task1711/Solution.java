package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

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
        int id;
        String name;
        String sex;
        Date bd;
        Person person;

        switch (args[0]) {
            case "-c":
                for (int i = 1; i < args.length; i++) {
                    synchronized (allPeople){
                        name = args[i];
                        sex =  args[++i];
                        bd = dateFormat.parse(args[++i]);
                        createHuman(name, sex, bd);
                    }
                }
                break;
            case "-u":
                for (int i = 1; i < args.length; i++) {
                    synchronized (allPeople){
                        id = Integer.parseInt(args[i]);
                        name = args[++i];
                        sex = args[++i];
                        bd = dateFormat.parse(args[++i]);
                        person = allPeople.get(id);
                        updateHuman(person, name, sex, bd);
                        //System.out.println("Пользователь " + person.getName() + " обновлен.");
                    }
                }
                break;
            case "-d":
                for (int i = 1; i < args.length; i++) {
                    synchronized (allPeople){
                        id = Integer.parseInt(args[i]);
                        person = allPeople.get(id);
                        deleteHuman(person);
                    }
                }
                break;
            case "-i":
                for (int i = 1; i < args.length; i++) {
                    synchronized (allPeople){
                        id = Integer.parseInt(args[i]);
                        person = allPeople.get(id);
                        informHuman(person);
                    }
                }
                break;
        }
    }
}
