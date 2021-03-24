package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {

    public void printString(String s) {
        System.out.println(s);
    }

    public void printStringFromInteger(int i) {
        System.out.println(i);
    }
}
