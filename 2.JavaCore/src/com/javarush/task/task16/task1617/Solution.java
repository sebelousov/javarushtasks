package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
        //add your code here - добавь код тут

    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            int seconds = numSeconds;
            while (numSeconds >= 0) {
                try {
                    Thread.sleep(1000);

                    if (numSeconds == 0 && seconds == 3) {
                        System.out.print("Марш!");
                    }
                    else if (numSeconds == 0 && seconds == 4) {
                        System.out.print("Прервано!");
                    }
                    else {
                        System.out.print(numSeconds + " ");
                    }

                    numSeconds--;
                }
                catch (InterruptedException e) {

                }

            }
        }
    }
}
