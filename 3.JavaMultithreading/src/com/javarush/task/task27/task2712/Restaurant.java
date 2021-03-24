package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.List;
import java.util.Map;

public class Restaurant {

    public static void main(String[] args) {
        Tablet tablet = new Tablet(1);
        Cook cook = new Cook("Михаил");
        Waiter waiter = new Waiter();

        tablet.addObserver(cook);
        cook.addObserver(waiter);

        tablet.createOrder();
        

    }
}
