package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream
        // according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("data", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            for (int i = 0; i < 4; i++) {
                javaRush.users.add(new User());
            }

            javaRush.users.get(0).setFirstName("Bob");
            javaRush.users.get(0).setLastName("Bobo");
            javaRush.users.get(0).setBirthDate(new Date());
            javaRush.users.get(0).setMale(true);
            javaRush.users.get(0).setCountry(User.Country.RUSSIA);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (outputStream == null) throw new Exception();

            PrintWriter writer = new PrintWriter(outputStream);
            for (User us : users) {
                writer.println(us.getFirstName());
                writer.println(us.getLastName());
                writer.println(us.getBirthDate().getTime());
                writer.println(us.isMale());
                writer.println(us.getCountry());//implement this method - реализуйте этот метод
            }
            writer.close();
            outputStream.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (inputStream == null) throw new Exception();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // int i=0;
            String line;
            while ((line = reader.readLine()) != null) {
//firstName
                String firstName = line;

//lastName
                String lastName = reader.readLine();

//Date
                String date = reader.readLine();
                Long longdate = Long.parseLong(date);
                Date BirthDate = new Date(longdate);

//Sex
                String sex = reader.readLine();
                boolean isTrue = true;
                if (sex.equals("true"))
                    isTrue = true;
                if (sex.equals("false"))
                    isTrue = false;

//Country
                String country = reader.readLine();
                User.Country enumCountry = null;
                switch (country) {
                    case "UKRAINE":
                        enumCountry = User.Country.UKRAINE;
                        break;
                    case "RUSSIA":
                        enumCountry = User.Country.RUSSIA;
                        break;
                    case "OTHER":
                        enumCountry = User.Country.OTHER;
                        break;
                }

//Create new User
                User user = new User();

//Put data to a new User
                user.setFirstName(firstName);
                user.setLastName(lastName);//implement this method - реализуйте этот метод
                user.setBirthDate(BirthDate);
                user.setMale(isTrue);
                user.setCountry(enumCountry);

//add user to users list
                users.add(user);
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "JavaRush{" +
                    "users=" + users +
                    '}';
        }
    }
}
