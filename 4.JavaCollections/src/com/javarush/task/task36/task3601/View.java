package com.javarush.task.task36.task3601;

import java.util.List;

public class View {
    Controller controller;

    public View() {
        this.controller = new Controller();
    }

    public void fireShowDataEvent() {
        System.out.println(controller.onShowDataList());
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
