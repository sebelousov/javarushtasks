package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {
        if (view == null || providers == null) throw new IllegalArgumentException("Null-arguments in Model");
        if (providers.length == 0) throw new IllegalArgumentException("Size of providers equals 0");

        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city) {
        if (city == null || city.isEmpty()) throw new IllegalArgumentException();

        List<Vacancy> vacancies = new ArrayList<>();

        for (Provider p : providers)
            vacancies.addAll(p.getJavaVacancies(city));

        view.update(vacancies);
    }
}
