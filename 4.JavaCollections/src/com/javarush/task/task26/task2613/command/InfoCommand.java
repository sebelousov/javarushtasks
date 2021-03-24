package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Collection;
import java.util.ResourceBundle;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute() throws InterruptOperationException {
        Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (manipulators.size() == 0) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
            return;
        }

        ConsoleHelper.writeMessage(res.getString("before"));

        for (CurrencyManipulator e : manipulators) {
            if (e.hasMoney()) {
                ConsoleHelper.writeMessage(String.format("%s - %d", e.getCurrencyCode(), e.getTotalAmount()));
            }
            else  {
                ConsoleHelper.writeMessage(res.getString("no.money"));
            }

        }

    }
}
