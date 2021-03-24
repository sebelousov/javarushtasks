package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    private List<Throwable> list = new ArrayList<>();
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        //System.out.printf("%s: %s%n", e.getClass().getCanonicalName(), e.getMessage());

        list.add(e);
        if (e.getCause() != null) uncaughtException(t, e.getCause());
        else {
            for (int i = list.size(); i > 0; i--) {
                System.out.printf("%s: %s%n", list.get(i - 1).getClass().getCanonicalName(), list.get(i - 1).getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Solution().uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
