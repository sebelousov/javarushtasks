package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }

    public static String readString() throws InterruptOperationException {
        try {
            String out = bis.readLine();
            if (out.toLowerCase().contains("exit")) {
                writeMessage(res.getString("the.end"));
                throw new InterruptOperationException();
            }
            return out;
        } catch (IOException e) {

        }
        return null;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            String currencyCode = readString();
            if (currencyCode != null && currencyCode.length() == 3) return currencyCode.toUpperCase();
            writeMessage(res.getString("invalid.data"));
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"), "USD"));
            String validTwoDigits = readString();

            if (validTwoDigits != null && validTwoDigits.matches("\\d+\\s\\d+")) {
                return validTwoDigits.split("\\s");
            }

            writeMessage(currencyCode);
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.operation"));
            writeMessage(res.getString("operation.INFO"));
            writeMessage(res.getString("operation.DEPOSIT"));
            writeMessage(res.getString("operation.WITHDRAW"));
            writeMessage(res.getString("operation.EXIT"));


            String operation = readString();

            if (operation != null) {
                try {
                    int number = Integer.parseInt(operation);
                    if (number == 0) throw new IllegalArgumentException();
                    return Operation.getAllowableOperationByOrdinal(number);
                }
                catch (IllegalArgumentException e) {

                }
            }

            writeMessage("Data is not correct...");
        }
    }
}
