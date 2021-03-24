package com.javarush.task.task16.task1632;

public class Thread01 extends Thread {



    @Override
    public void run() {
        while (true) {
            try {
                sleep(2000);
            }
            catch (InterruptedException e) {
                System.out.println("InterruptedException");
                break;
            }
        }
    }
}
