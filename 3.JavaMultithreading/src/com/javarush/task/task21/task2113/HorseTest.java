package com.javarush.task.task21.task2113;

public class HorseTest {
    private String name;
    private double speed = 3;
    private double distance = 0;

    public void move() {
        System.out.println(distance);
        this.distance =+ speed * Math.random();
        System.out.println(distance);
    }

    public static void main(String[] args) {
        HorseTest horseTest = new HorseTest();
        horseTest.move();
    }
}
