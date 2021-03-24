package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static CurrencyManipulatorFactory factory;
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulatorFactory getInstance() {
        if (factory == null) {
            factory = new CurrencyManipulatorFactory();
        }
        return factory;
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {

        String code = currencyCode.toUpperCase();

        if (map.containsKey(code)) return map.get(code);
        else {
            CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode.toUpperCase());
            map.put(code, manipulator);
            return manipulator;
        }

    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}
