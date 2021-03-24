package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;
import javassist.compiler.ast.StringL;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogParser implements DateQuery, EventQuery, IPQuery, QLQuery, UserQuery {
    private Path logDir;
    private Set<File> logsFiles = new HashSet<>();
    private Set<StringLog> logs = new HashSet<>();

    public LogParser(Path logDir) {
        this.logDir = logDir;

        try {
            getLogFilesFromLogDir(logDir);
            if (logsFiles.size() != 0) loadLogs();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void loadLogs() throws IOException, ParseException {
        for (File f : logsFiles) {
            loadLogFromFile(f);
        }
    }

    private void loadLogFromFile(File file) throws IOException, ParseException {
        List<String> strings = Files.readAllLines(Paths.get(file.getAbsolutePath()));
        for (String e : strings) {
            String[] oneString = e.split("\\t");
            String ip = oneString[0];
            String user = oneString[1];
            Date date = getDateFromString(oneString[2]);
            String dateStr = oneString[2];

            String[] eventArr = oneString[3].split(" ");
            Event event = getEnumEventFromString(eventArr[0]);

            int task =  0;
            if (eventArr.length == 2)
                task = Integer.parseInt(eventArr[1]);

            Status status = getEnumStatusFromString(oneString[4]);

            logs.add(new StringLog(ip, user, date, dateStr, event, task, status));
        }

    }

    private void getLogFilesFromLogDir(Path logDir) throws IOException {
        if (Files.isDirectory(logDir)) {
            File dir = new File(logDir.toString());
            File[] arrFiles = dir.listFiles();
            if (arrFiles != null)
                logsFiles = Arrays.stream(arrFiles)
                    .filter(f ->
                            f.isFile() &&
                            f.getName().endsWith(".log"))
                    .collect(Collectors.toSet());
        }
        else {
            throw new IllegalArgumentException("Путь не является директорией.");
        }
    }

    private Date getDateFromString(String s) throws ParseException {
        String pattern = "dd.MM.yyyy HH:mm:ss";
        DateFormat formatter = new SimpleDateFormat(pattern);
        Date date = formatter.parse(s);
        return date;
    }

    private Event getEnumEventFromString(String s) {
        if (Event.DONE_TASK.name().equals(s)) return Event.DONE_TASK;
        else if (Event.DOWNLOAD_PLUGIN.name().equals(s)) return Event.DOWNLOAD_PLUGIN;
        else if (Event.LOGIN.name().equals(s)) return Event.LOGIN;
        else if (Event.SOLVE_TASK.name().equals(s)) return Event.SOLVE_TASK;
        else if (Event.WRITE_MESSAGE.name().equals(s)) return Event.WRITE_MESSAGE;
        else throw new IllegalArgumentException("Неверный аргумент для определния Enum.Event.");
    }

    private Status getEnumStatusFromString(String s) {
        if (Status.ERROR.name().equals(s)) return Status.ERROR;
        else if (Status.FAILED.name().equals(s)) return Status.FAILED;
        else if (Status.OK.name().equals(s)) return Status.OK;
        else throw new IllegalArgumentException("Неверный аргумент для определния Enum.Status.");
    }

    public Set<StringLog> getLogs() {
        return logs;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> ips = getUniqueIPs(after, before);
        return ips.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ips = new HashSet<>();
        if (after == null && before == null) {
            for (StringLog e : logs) {
                ips.add(e.getIp());
            }
        }
        else if (after == null && before != null) {
            for (StringLog e : logs) {
                if (e.getDate().before(before)) ips.add(e.getIp());
            }
        }
        else if (after != null && before == null) {
            for (StringLog e : logs) {
                if (e.getDate().after(after)) ips.add(e.getIp());
            }
        }
        else if (after != null && before != null) {
            for (StringLog e : logs) {
                if (e.getDate().after(after) && e.getDate().before(before)) ips.add(e.getIp());
            }
        }

        return ips;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        if (after == null && before == null) {
            for (StringLog e : logs) {
                if (e.getUser().equals(user)) ips.add(e.getIp());
            }
        }
        else if (after == null && before != null) {
            for (StringLog e : logs) {
                if (e.getDate().before(before) && e.getUser().equals(user)) ips.add(e.getIp());
            }
        }
        else if (after != null && before == null) {
            for (StringLog e : logs) {
                if (e.getDate().after(after) && e.getUser().equals(user)) ips.add(e.getIp());
            }
        }
        else if (after != null && before != null) {
            for (StringLog e : logs) {
                if (e.getDate().after(after) && e.getDate().before(before) && e.getUser().equals(user)) ips.add(e.getIp());
            }
        }

        return ips;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        if (after == null && before == null) {
            for (StringLog e : logs) {
                if (e.getEvent() == event) ips.add(e.getIp());
            }
        }
        else if (after == null && before != null) {
            for (StringLog e : logs) {
                if (e.getDate().before(before) && e.getEvent() == event) ips.add(e.getIp());
            }
        }
        else if (after != null && before == null) {
            for (StringLog e : logs) {
                if (e.getDate().after(after) && e.getEvent() == event) ips.add(e.getIp());
            }
        }
        else if (after != null && before != null) {
            for (StringLog e : logs) {
                if (e.getDate().after(after) && e.getDate().before(before) && e.getEvent() == event) ips.add(e.getIp());
            }
        }

        return ips;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        if (after == null && before == null) {
            for (StringLog e : logs) {
                if (e.getStatus() == status) ips.add(e.getIp());
            }
        }
        else if (after == null && before != null) {
            for (StringLog e : logs) {
                if (e.getDate().before(before) && e.getStatus() == status) ips.add(e.getIp());
            }
        }
        else if (after != null && before == null) {
            for (StringLog e : logs) {
                if (e.getDate().after(after) && e.getStatus() == status) ips.add(e.getIp());
            }
        }
        else if (after != null && before != null) {
            for (StringLog e : logs) {
                if (e.getDate().after(after) && e.getDate().before(before) && e.getStatus() == status) ips.add(e.getIp());
            }
        }

        return ips;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> users = new HashSet<>();
        for (StringLog e : logs) {
            users.add(e.getUser());
        }
        return users;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> users = logs.stream()
                .filter(e -> dateMatch(e, after, before))
                .map(StringLog::getUser)
                .collect(Collectors.toSet());

        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> events = new HashSet<>();

        if (after == null && before == null) {
            for (StringLog e : logs) {
                if (e.getUser().equals(user)) events.add(e.getEvent());
            }
        }
        else if (after == null && before != null) {
            for (StringLog e : logs) {
                if (e.getDate().before(before) && e.getUser().equals(user)) events.add(e.getEvent());
            }
        }
        else if (after != null && before == null) {
            for (StringLog e : logs) {
                if (e.getDate().after(after) && e.getUser().equals(user)) events.add(e.getEvent());
            }
        }
        else if (after != null && before != null) {
            for (StringLog e : logs) {
                if (e.getDate().after(after) && e.getDate().before(before) && e.getUser().equals(user)) events.add(e.getEvent());
            }
        }

        return events.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> users = new HashSet<>();

        if (after == null && before == null) {
            for (StringLog e : logs) {
                if (e.getIp().equals(ip)) users.add(e.getUser());
            }
        }
        else if (after == null && before != null) {
            for (StringLog e : logs) {
                if (e.getDate().before(before) && e.getIp().equals(ip)) users.add(e.getUser());
            }
        }
        else if (after != null && before == null) {
            for (StringLog e : logs) {
                if (e.getDate().after(after) && e.getIp().equals(ip)) users.add(e.getUser());
            }
        }
        else if (after != null && before != null) {
            for (StringLog e : logs) {
                if (e.getDate().after(after) && e.getDate().before(before) && e.getIp().equals(ip)) users.add(e.getUser());
            }
        }

        return users;
    }

    private boolean dateMatch(StringLog stringLog, Date after, Date before) {
        if (after == null && before == null) {
            return true;
        }
        else if (after == null && before != null) {
            return stringLog.getDate().before(before);
        }
        else if (after != null && before == null) {
            return stringLog.getDate().after(after);
        }
        else if (after != null && before != null) {
            return stringLog.getDate().after(after) && stringLog.getDate().before(before);
        }
        else {
            return false;
        }
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {

        return logs.stream()
                .filter(e -> dateMatch(e, after, before) && e.getEvent() == Event.LOGIN)
                .map(StringLog::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getEvent() == Event.DOWNLOAD_PLUGIN &&
                        e.getStatus() == Status.OK)
                .map(StringLog::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getEvent() == Event.WRITE_MESSAGE &&
                        e.getStatus() == Status.OK)
                .map(StringLog::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getEvent() == Event.SOLVE_TASK)
                .map(StringLog::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getEvent() == Event.SOLVE_TASK &&
                        e.getTask() == task)
                .map(StringLog::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getEvent() == Event.DONE_TASK)
                .map(StringLog::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getEvent() == Event.DONE_TASK &&
                        e.getTask() == task)
                .map(StringLog::getUser)
                .collect(Collectors.toSet());
    }

    public Set<Date> getAllDates(Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before))
                .map(StringLog::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getUser().equals(user) &&
                        e.getEvent() == event)
                .map(StringLog::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getStatus() == Status.FAILED)
                .map(StringLog::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getStatus() == Status.ERROR)
                .map(StringLog::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Set<Date> dates;

        dates = logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getEvent() == Event.LOGIN &&
                        e.getUser().equals(user))
                .map(StringLog::getDate)
                .collect(Collectors.toSet());

        if (dates.size() != 0) {
            if (dates.size() == 1)
                for (Date d : dates)
                    return d;
            else {
                return Collections.min(dates);
            }
        }

        return null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Set<Date> dates;

        dates = logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getEvent() == Event.SOLVE_TASK &&
                        e.getTask() == task &&
                        e.getUser().equals(user))
                .map(StringLog::getDate)
                .collect(Collectors.toSet());

        if (dates.size() != 0) {
            if (dates.size() == 1)
                for (Date d : dates)
                    return d;
            else {
                return Collections.min(dates);
            }
        }

        return null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Set<Date> dates;

        dates = logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getEvent() == Event.DONE_TASK &&
                        e.getTask() == task &&
                        e.getUser().equals(user))
                .map(StringLog::getDate)
                .collect(Collectors.toSet());

        if (dates.size() != 0) {
            if (dates.size() == 1)
                for (Date d : dates)
                    return d;
            else {
                return Collections.min(dates);
            }
        }

        return null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getEvent() == Event.WRITE_MESSAGE &&
                        e.getUser().equals(user))
                .map(StringLog::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                                e.getEvent() == Event.DOWNLOAD_PLUGIN &&
                                e.getUser().equals(user))
                .map(StringLog::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return logs.stream()
                .filter(e -> dateMatch(e, after, before))
                .map(StringLog::getEvent)
                .collect(Collectors.toSet());
    }

    public Set<Status> getAllStatuses(Date after, Date before) {
        return logs.stream()
                .filter(e -> dateMatch(e, after, before))
                .map(StringLog::getStatus)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getIp().equals(ip))
                .map(StringLog::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getUser().equals(user))
                .map(StringLog::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getStatus() == Status.FAILED)
                .map(StringLog::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getStatus() == Status.ERROR)
                .map(StringLog::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getEvent() == Event.SOLVE_TASK &&
                        e.getTask() == task)
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getEvent() == Event.DONE_TASK &&
                        e.getTask() == task)
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getEvent() == Event.SOLVE_TASK)
                .forEach(e -> {
                    int task = e.getTask();
                    int value = 0;
                    if (map.get(task) == null)
                        map.put(task, 1);
                    else {
                        value = map.get(task);
                        map.put(task, value + 1);
                    }

                });

        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        logs.stream()
                .filter(e ->
                        dateMatch(e, after, before) &&
                        e.getEvent() == Event.DONE_TASK)
                .forEach(e -> {
                    int task = e.getTask();
                    int value = 0;
                    if (map.get(task) == null)
                        map.put(task, 1);
                    else {
                        value = map.get(task);
                        map.put(task, value + 1);
                    }

                });

        return map;
    }

    @Override
    public Set<Object> execute(String query) {
        if (query == null || query.isEmpty()) throw new IllegalArgumentException();

        //System.out.println(query);

        // get ip for user = "Eduard Petrovich Morozko" and date between "11.12.2013 0:00:00" and "03.01.2014 23:59:59"
        // 1) get ip for user = "Vasya Pupkin"
        // 2) get user for event = "DONE_TASK"
        // 3) get event for date = "03.01.2014 03:45:23"

        String field1 = null;
        String field2 = null;
        String value1 = null;
        Date after = null;
        Date before = null;

        if (!query.contains(" for ")) {
            field1 = query.substring(4);
            switch (field1) {
                case "ip":
                    Set<String> ips = getUniqueIPs(null, null);
                    return ips != null ? new HashSet<>(ips) : null;
                case "user":
                    Set<String> users = getAllUsers();
                    return users != null ? new HashSet<>(users) : null;
                case "date":
                    Set<Date> dates = getAllDates(null, null);
                    return dates != null ? new HashSet<>(dates) : null;
                case "event":
                    Set<Event> events = getAllEvents(null, null);
                    return events != null ? new HashSet<>(events) : null;
                case "status":
                    Set<Status> statuses = getAllStatuses(null, null);
                    return statuses != null ? new HashSet<>(statuses) : null;
            }
        } else if (query.contains(" for ") && !query.contains(" between ")) {
            field1 = query.substring(4, query.indexOf(" for"));
            field2 = query.substring(query.indexOf(" for ") + 5, query.indexOf(" = "));
            value1 = query.substring(query.indexOf(" = \"") + 4, query.length() - 1);
            return getDataFromLogForField1AndField2(field1, field2, value1);
        }
        else if (query.contains(" for ") && query.contains(" between ")) {
            field1 = query.substring(4, query.indexOf(" for"));
            field2 = query.substring(query.indexOf(" for ") + 5, query.indexOf(" = "));
            value1 = query.substring(query.indexOf(" = \"") + 4, query.indexOf("\" and"));
            try {
                after = getDateFromString(query.substring(query.indexOf(" between \"") + 10, query.indexOf("\" and \"")));
                before = getDateFromString(query.substring(query.indexOf("\" and \"") + 7, query.length() - 1));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return getDataFromLogForField1Field2AndDate(field1, field2, value1, after, before);
        }

        return null;
    }

    public Set<Object> getDataFromLogForField1AndField2(String field1, String field2, String value1) {
        if (
                field1 == null ||
                field2 == null ||
                value1 == null ||
                field1.isEmpty() ||
                field2.isEmpty() ||
                value1.isEmpty()
        )
            return null;

        String methodField1 = "get" + field1.substring(0, 1).toUpperCase() + field1.substring(1);
        String methodField2 = "get" + field2.substring(0, 1).toUpperCase() + field2.substring(1);
        String methodFieldForDate = "getDateStr";

        return logs.stream()
                .filter(e -> {
                    try {
                        if (field2.equals("date")) {
                            Method method = e.getClass().getDeclaredMethod(methodFieldForDate);
                            String temp = method.invoke(e).toString();
                            return temp.equals(value1);
                        }
                        else {
                            Method method = e.getClass().getDeclaredMethod(methodField2);
                            String temp = method.invoke(e).toString();
                            return temp.equals(value1);
                        }
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                    return false;
                })
                .map(e -> {
                    try {
                        Method method = e.getClass().getDeclaredMethod(methodField1);
                        return method.invoke(e);
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toSet());
    }

    public Set<Object> getDataFromLogForField1Field2AndDate(String field1, String field2, String value1, Date after, Date before) {
        if (
                field1 == null ||
                field2 == null ||
                value1 == null ||
                field1.isEmpty() ||
                field2.isEmpty() ||
                value1.isEmpty()
        )
            return null;

        String methodField1 = "get" + field1.substring(0, 1).toUpperCase() + field1.substring(1);
        String methodField2 = "get" + field2.substring(0, 1).toUpperCase() + field2.substring(1);
        String methodFieldForDate = "getDateStr";

        return logs.stream()
                .filter(e -> {
                    try {
                        if (field2.equals("date")) {
                            Method method = e.getClass().getDeclaredMethod(methodFieldForDate);
                            String temp = method.invoke(e).toString();
                            return temp.equals(value1) &&
                                   dateMatch(e, after, before);
                        }
                        else {
                            Method method = e.getClass().getDeclaredMethod(methodField2);
                            String temp = method.invoke(e).toString();
                            return temp.equals(value1) &&
                                   dateMatch(e, after, before);
                        }
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                    return false;
                })
                .map(e -> {
                    try {
                        Method method = e.getClass().getDeclaredMethod(methodField1);
                        return method.invoke(e);
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toSet());
    }
}