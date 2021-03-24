package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class ExitCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        while (true) {
            String answer = ConsoleHelper.readString();
            if (answer != null) {
                if (answer.toLowerCase().equals("y")) {
                    ConsoleHelper.writeMessage(res.getString("thank.message"));
                    break;
                }
                else if (answer.toLowerCase().equals("n")) {
                    break;
                }
                else {

                }
            }

        }
    }
}
