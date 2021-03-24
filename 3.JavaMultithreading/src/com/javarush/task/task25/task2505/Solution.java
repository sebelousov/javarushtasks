package com.javarush.task.task25.task2505;

/* 
Без дураков
*/
public class Solution {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
        myThread.join();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            //setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

            @Override
            public void uncaughtException(Thread t, Throwable e) {

                try {
                    Thread.sleep(500);
                    String str = String.format("%s, %s, %s", secretKey, t.getName(), e.getMessage());
                    if (!t.isDaemon()) System.out.println(str);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }
        }
    }

}

