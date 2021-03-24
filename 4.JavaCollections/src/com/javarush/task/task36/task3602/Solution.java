package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {


        Class[] classes = Collections.class.getDeclaredClasses();
        List<Class> out = new LinkedList<>();

        for (Class c : classes) {
            for (Class i : c.getInterfaces()) {
                if (i.getSimpleName().equals("List")) out.add(c);
            }
            for (Class i : c.getSuperclass().getInterfaces()) {
                if (i.getSimpleName().equals("List")) out.add(c);
            }

        }

        List<Class> outCopy = new LinkedList<>(out);

        for (Class c : outCopy) {
            int mod = c.getModifiers();
            if (!(Modifier.isStatic(mod) && Modifier.isPrivate(mod))) out.remove(c);
        }

        outCopy = null;
        outCopy = new LinkedList<>(out);

        for (Class c : outCopy) {
            try {
                if (c.getDeclaredConstructor().getParameterCount() == 0) return c;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

//            Method method = c.getDeclaredMethod("get", int.class);
//            method.setAccessible(true);
//            Constructor constructor = c.getDeclaredConstructor();
//            constructor.setAccessible(true);
//
//            try {
//                method.invoke(constructor.newInstance(), 0);
//            }
//            catch (InvocationTargetException e) {
//                if (e.getCause().toString().equals("IndexOutOfBoundsException")) return c;
//            }
        }

        return null;
    }
}
