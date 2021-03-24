package com.javarush.task.task39.task3913;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        String[] queries = new String[] {
                "get ip",
                "get user",
                "get date",
                "get event",
                "get status",
                "get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"",
                "get ip for user = \"Amigo\"",
                "get ip for date = \"19.03.2016 00:00:00\"",
                "get ip for event = \"SOLVE_TASK\"",
                "get ip for status = \"FAILED\"",
                "get user for ip = \"127.0.0.1\"",
                "get user for date = \"19.03.2016 00:00:00\"",
                "get user for event = \"SOLVE_TASK\"",
                "get user for status = \"FAILED\"",
                "get date for ip = \"127.0.0.1\"",
                "get date for user = \"Amigo\"",
                "get date for event = \"SOLVE_TASK\"",
                "get date for status = \"FAILED\"",
                "get event for ip = \"127.0.0.1\"",
                "get event for user = \"Amigo\"",
                "get event for date = \"19.03.2016 00:00:00\"",
                "get event for status = \"FAILED\"",
                "get status for ip = \"127.0.0.1\"",
                "get status for user = \"Amigo\"",
                "get status for date = \"19.03.2016 00:00:00\"",
                "get status for event = \"SOLVE_TASK\""
        };

        LogParser logParser = new LogParser(Paths.get("D:/OneDrive/java/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs"));
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));

//        for (String e : queries) {
//            System.out.println(e);
//            System.out.println(logParser.execute(e));
//        }






//        String afterStr = "30.08.2012 16:10:00";
//        String beforeStr = "05.01.2021 20:22:55";
//        String pattern = "dd.MM.yyyy HH:mm:ss";
//        DateFormat formatter = new SimpleDateFormat(pattern);
//        Date after = formatter.parse(afterStr);
//        Date before = formatter.parse(beforeStr);


    }
}