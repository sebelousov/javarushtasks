package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        int count = 23;
        return count;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}