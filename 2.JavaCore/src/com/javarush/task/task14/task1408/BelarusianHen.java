package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        int count = 19;
        return count;
    }

    public String getDescription() {

        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}