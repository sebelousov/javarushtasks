package com.javarush.task.task22.task2201;

public class TestSolution {
    String string = "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ";

    public static void main(String[] args) {
        TestSolution test = new TestSolution();
        System.out.println(test.getPartOfString(test.string));
    }

    public String getPartOfString(String string) {
        int x = string.indexOf("\t");
        int y = string.lastIndexOf("\t");

        if (string.length() < 3) {
            x = -1;
            y = -1;
        }
        else {
            x++;

        }
        //System.out.format("%s - %s\n", x, y);
        return string.substring(x, y);

    }
}
