package com.javarush.task.task25.task2514;

import java.util.Random;

/*
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new YieldRunnable(new Random(10).nextInt()));
        Thread thread2 = new Thread(new YieldRunnable(new Random(10).nextInt()));
        Thread thread3 = new Thread(new YieldRunnable(new Random(10).nextInt()));
        Thread thread4 = new Thread(new YieldRunnable(new Random(10).nextInt()));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
