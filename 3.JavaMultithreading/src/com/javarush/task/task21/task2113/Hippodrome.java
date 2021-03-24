package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse h : game.getHorses()) {
            h.move();
        }
    }

    public void print() {
        for (Horse h : game.getHorses()) {
            h.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
//        double max = game.getHorses().get(0).getDistance();
//        int count = 0;
//        for (int i = 0; i < game.getHorses().size(); i++) {
//            double currentDistanceHorse = game.getHorses().get(i).getDistance();
//            if (currentDistanceHorse > max) {
//                max = currentDistanceHorse;
//                count = i;
//            }
//        }
//        Horse winner = game.getHorses().get(count);

        return horses.stream()
                .max(Comparator.comparingDouble(Horse::getDistance))
                .get();
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("Беляночка", 3.0, 0.0));
        game.getHorses().add(new Horse("Кнопочка", 3.0, 0.0));
        game.getHorses().add(new Horse("Зопочка", 3.0, 0.0));

        try {
            game.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        game.printWinner();
    }

}
