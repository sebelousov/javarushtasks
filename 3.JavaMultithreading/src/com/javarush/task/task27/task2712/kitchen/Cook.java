package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    private void startCooking (Order order) {
        ConsoleHelper.writeMessage("Start cooking - " + order);
    }

    @Override
    public void update(Observable o, Object arg) {
        Order order = (Order) arg;

        CookedOrderEventDataRow eventDataRow = new CookedOrderEventDataRow(
                order.getTablet().toString(),
                this.name,
                order.getTotalCookingTime() * 60,
                order.getDishes());
        StatisticManager.getInstance().register(eventDataRow);

        startCooking(order);
        setChanged();
        notifyObservers(order);
    }
}
