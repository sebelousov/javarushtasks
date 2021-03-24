package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            int oldCount = denominations.get(denomination);
            denominations.put(denomination, count + oldCount);
        }
        else {
            denominations.put(denomination, count);
        }
    }

    public Map<Integer, Integer> withdrawAmount(int expectedMoney) throws NotEnoughMoneyException {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        List<Integer> nominals = new ArrayList<>(map.size());
        int amountOfOperation = 0;

        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            nominals.add(entry.getKey());
        }

        nominals.sort(Comparator.reverseOrder());

        while (expectedMoney > 0) {
            for (Integer e : nominals) {
                int oldCount = denominations.get(e);
                if (oldCount > 0 && expectedMoney >= e) {
                    expectedMoney -= e;
                    System.out.println(expectedMoney);
                    denominations.put(e, oldCount - 1);
                    if (map.containsKey(e)) {
                        int count = map.get(e);
                        map.put(e, count + 1);
                    }
                    else {
                        map.put(e, 1);
                    }
                    amountOfOperation++;
                    break;
                }
            }

            if (amountOfOperation == 0) throw new NotEnoughMoneyException();
            amountOfOperation = 0;
        }

        return map;
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            totalAmount += entry.getKey() * entry.getValue();
        }
        return totalAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public boolean hasMoney() {
        return denominations.size() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        if (!hasMoney()) return false;

        int amount = getTotalAmount();
        return amount >= expectedAmount;
    }
}
