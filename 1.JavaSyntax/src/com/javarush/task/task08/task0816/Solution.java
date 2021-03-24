package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Stalone", df.parse("JULY 2 1980"));
        map.put("Tallon", df.parse("AUGUST 3 1980"));
        map.put("Allone", df.parse("JANUARY 4 1980"));
        map.put("Alone", df.parse("JUNE 5 1980"));
        map.put("Stall", df.parse("JULY 6 1980"));
        map.put("Stal", df.parse("AUGUST 7 1980"));
        map.put("Stallon", df.parse("OCTOBER 8 1980"));
        map.put("Stalon", df.parse("NOVEMBER 9 1980"));
        map.put("Sallone", df.parse("MARCH 1 1980"));

        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Calendar cal = Calendar.getInstance();

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            //String name = pair.getKey();
            Date date = pair.getValue();
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH);
            if (month > 4 && month < 8) iterator.remove();
        }

    }

    public static void main(String[] args) {

    }
}
