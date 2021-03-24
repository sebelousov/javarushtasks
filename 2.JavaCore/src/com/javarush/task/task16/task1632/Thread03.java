package com.javarush.task.task16.task1632;

public class Thread03 extends Thread implements Message {
    boolean isInterrupt = false;

    public void showWarning() {
        isInterrupt = true;
    }

    @Override
    public void run() {

        while (!isInterrupt) {

        }
    }
}
