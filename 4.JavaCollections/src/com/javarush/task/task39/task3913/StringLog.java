package com.javarush.task.task39.task3913;

import java.util.Date;

public class StringLog {
    private String ip;
    private String user;
    private Date date;
    private String dateStr;

    private Event event;
    private int task;
    private Status status;

    public StringLog(String ip, String user, Date date, String dateStr, Event event, int task, Status status) {
        this.ip = ip;
        this.user = user;
        this.date = date;
        this.dateStr = dateStr;
        this.event = event;
        this.task = task;
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public String getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public String getDateStr() {
        return dateStr;
    }

    public Event getEvent() {
        return event;
    }

    public int getTask() {
        return task;
    }

    public Status getStatus() {
        return status;
    }
}
