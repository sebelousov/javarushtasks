package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.*;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Aggregator {

    public static void main(String[] args) {
        HtmlView view = new HtmlView();
        Model model = new Model(view, new Provider(new HHStrategy()), new Provider(new MoikrugStrategy()));
        Controller controller = new Controller(model);
        view.setController(controller);

        view.userCitySelectEmulationMethod();

//        try {
//            List<Vacancy> vacancies = new ArrayList<>();
//            vacancies.add(new Vacancy("Junior Java Developer 1", "1000", "Voronegh", "Microsoft", "hh.ru", "http://ya.ru/"));
//            vacancies.add(new Vacancy("Junior Java Developer 2", "2000", "Minsk", "Soft", "hh.ru", "http://ya1.ru/"));
//            vacancies.add(new Vacancy("Junior Java Developer 3", "3000", "Kiev", "Micro", "hh.ru", "http://ya2.ru/"));
//            vacancies.add(new Vacancy("Junior Java Developer 4", "4000", "Moscow", "MS", "hh.ru", "http://ya3.ru/"));
//
//            String filePath = view.getFilePath();
//            File in = new File(filePath);
//            Document doc = Jsoup.parse(in, "UTF-8");
//
//
//            Element elementTemplate = doc.getElementsByClass("template").first();
//            Element template = (Element) elementTemplate.clone().removeClass("template")
//                    .removeAttr("style");
//
//            doc.select("tr[class=vacancy]").remove();
//
//            for (Vacancy v : vacancies) {
//                Element templateClone = template.clone();
//                Element titleElement = templateClone
//                        .select("a")
//                        .first();
//                titleElement.text(v.getTitle());
//                titleElement.attr("href", v.getUrl());
//                Element cityElement = templateClone
//                        .select("td.city")
//                        .first();
//                cityElement.text(v.getCity());
//                Element companyNameElement = templateClone
//                        .select("td.companyName")
//                        .first();
//                companyNameElement.text(vacancies.get(0).getCompanyName());
//                Element salaryElement = templateClone
//                        .select("td.salary")
//                        .first();
//                salaryElement.text(v.getSalary());
//
//                doc.getElementsByClass("template").first().before(templateClone.outerHtml());
//            }
//
//            System.out.println(doc);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //view.userCitySelectEmulationMethod();

    }
}
