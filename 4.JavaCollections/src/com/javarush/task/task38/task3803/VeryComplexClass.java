package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object obj = new Integer(100);
        System.out.println((String) obj);

    }

    public void methodThrowsNullPointerException() {
        Object[] objects = null;
        System.out.println(objects[0]);
    }

    public static void main(String[] args) {

    }
}
