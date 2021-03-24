package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TestBotClient {
    public static void main(String[] args) {
        processIncomingMessage("Боб: дата");
        processIncomingMessage("Сергей: день");
        processIncomingMessage("Семен: месяц");
        processIncomingMessage("Андрей: год");
        processIncomingMessage("Яков: время");
        processIncomingMessage("Джон: час");
        processIncomingMessage("Ирина: минуты");
        processIncomingMessage("Чарльз: секунды");
        processIncomingMessage("Здесь не должно быть: сек");

    }

    public static void processIncomingMessage(String message) {
        String name = message.replaceAll(": .*", "");
        String textOfMessage = message.replaceAll(".*: ", "");
        String formatDate = null;
        System.out.println(message);
        switch (textOfMessage) {
            case "дата": formatDate = "d.MM.YYYY";
                break;
            case "день": formatDate = "d";
                break;
            case "месяц": formatDate = "MMMM";
                break;
            case "год": formatDate = "YYYY";
                break;
            case "время": formatDate = "H:mm:ss";
                break;
            case "час": formatDate = "H";
                break;
            case "минуты": formatDate = "m";
                break;
            case "секунды": formatDate = "s";
                break;
        }

        if (formatDate != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDate, Locale.ENGLISH);
            Calendar calendar = new GregorianCalendar();
            Date currentDate = calendar.getTime();
            System.out.println("Информация для " + name + ": " + simpleDateFormat.format(currentDate));
        }
    }
}
