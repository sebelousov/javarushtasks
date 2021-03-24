package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.model.Strategy;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private Model model;

    public Controller(Model model) {
        if (model == null) throw new IllegalArgumentException("Model in Controller is null");

        this.model = model;
    }

    public void onCitySelect(String cityName) {
        if (cityName == null || cityName.isEmpty()) throw new IllegalArgumentException();

        try {
            model.selectCity(URLEncoder.encode(cityName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

//    public void scan() {
//        List<Vacancy> vacancies = new ArrayList<>();
//        String query = "киев";
//        for (Provider e : providers) {
//            try {
//                vacancies.addAll(e.getJavaVacancies(URLEncoder.encode(query, "UTF-8")));
//            } catch (UnsupportedEncodingException ex) {
//                ex.printStackTrace();
//            }
//        }
//
//        System.out.println(vacancies.size());
//
//    }
}
