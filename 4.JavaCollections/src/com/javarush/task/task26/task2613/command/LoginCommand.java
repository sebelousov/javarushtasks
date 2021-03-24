package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("before");
        ConsoleHelper.writeMessage(res.getString("specify.data"));
        while (true) {
            String cardUser = ConsoleHelper.readString();
            String pinUser = ConsoleHelper.readString();

            if (cardUser != null && pinUser != null && cardUser.matches("\\d{12}") && pinUser.matches("\\d{4}")) {
                if (validCreditCards.containsKey(cardUser) && validCreditCards.getString(cardUser).equals(pinUser)) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardUser));
                    break;
                }
                else {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardUser));
                }
            }
            else {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
        }

    }
}
