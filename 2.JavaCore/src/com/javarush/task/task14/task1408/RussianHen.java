package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        int count = 20;
        return count;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}