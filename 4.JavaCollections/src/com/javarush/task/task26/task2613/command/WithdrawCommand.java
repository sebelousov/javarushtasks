package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        int amountOfMoney;
        Map<Integer, Integer> map;


        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String amountStr = ConsoleHelper.readString();
            if (amountStr != null && amountStr.matches("\\d+")) {
                amountOfMoney = Integer.parseInt(amountStr);
                if (manipulator.isAmountAvailable(amountOfMoney)) {
                    try {
                        map = manipulator.withdrawAmount(amountOfMoney);
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amountOfMoney, currencyCode));
                        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                            ConsoleHelper.writeMessage(String.format("%d - %d", entry.getKey(), entry.getValue()));
                        }
                        break;
                    } catch (NotEnoughMoneyException e) {
                        ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                    }
                }
                else {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                }
            }
            else {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
        }
    }
}
