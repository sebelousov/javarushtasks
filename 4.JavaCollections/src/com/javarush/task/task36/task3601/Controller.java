package com.javarush.task.task36.task3601;

import java.util.List;

public class Controller {
    private View view;
    private Model model;

    public Controller() {
        this.model = new Model();
    }

    public List<String> onShowDataList() {
        return model.getStringDataList();
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
