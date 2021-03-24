package com.javarush.task.task38.task3804;

public class FactoryExceptions {
    public static Throwable getException(Enum e) {
        if (e == null) return new IllegalArgumentException();

        String temp = e.name().toLowerCase().replaceAll("_", " ");
        String msg = temp.substring(0, 1).toUpperCase() + temp.substring(1);

        switch (e.getClass().getSimpleName()) {
            case "ApplicationExceptionMessage":

                return new Exception(msg);
            case "DatabaseExceptionMessage":

                return new RuntimeException(msg);
            case "UserExceptionMessage":

                return new Error(msg);
            default:
                return new IllegalArgumentException();
        }
    }
}
