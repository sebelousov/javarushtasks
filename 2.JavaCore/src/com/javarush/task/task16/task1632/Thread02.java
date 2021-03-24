package com.javarush.task.task16.task1632;

public class Thread02 extends Thread {



    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Ура");
                sleep(500);
            }
            catch (InterruptedException e) {

            }
        }
    }
}
