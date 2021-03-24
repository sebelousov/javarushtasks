package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

import java.lang.reflect.InvocationTargetException;

public class Solution {
    public static Class getFactoryClass() {
        return FactoryExceptions.class;
    }

    public static void main(String[] args) {
        System.out.println(FactoryExceptions.getException(ApplicationExceptionMessage.SOCKET_IS_CLOSED).getMessage());
        System.out.println(FactoryExceptions.getException(ApplicationExceptionMessage.UNHANDLED_EXCEPTION).getMessage());
        System.out.println(FactoryExceptions.getException(DatabaseExceptionMessage.NO_RESULT_DUE_TO_TIMEOUT).getMessage());
        System.out.println(FactoryExceptions.getException(DatabaseExceptionMessage.NOT_ENOUGH_CONNECTIONS).getMessage());
        System.out.println(FactoryExceptions.getException(UserExceptionMessage.USER_DOES_NOT_EXIST).getMessage());
        System.out.println(FactoryExceptions.getException(UserExceptionMessage.USER_DOES_NOT_HAVE_PERMISSIONS).getMessage());
    }
}