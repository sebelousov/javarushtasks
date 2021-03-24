package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private Service service;

    public Model() {
        this.service = new Service();
    }

    public List<String> getStringDataList() {
        return service.getData();
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
