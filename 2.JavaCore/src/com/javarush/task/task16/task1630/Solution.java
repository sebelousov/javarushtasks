package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static {
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }
        catch (IOException e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {


        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        String str = "";

        public StringBuilder sb = new StringBuilder();
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        public String getFileContent() {
            return str;
        }

        public void run() {

            try {
                BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
                while (br.ready()) {
                    str += br.readLine() + " ";
                }
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
