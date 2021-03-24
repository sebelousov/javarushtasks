package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT_TEST = "http://javarush.ru/testdata/big28data.html";
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    private static final String userAgent = "Mozilla/5.0 (jsoup)";
    private static final int timeout = 5 * 1000;

    private String referrer = "https://hh.ru/search/vacancy?area=1&clusters=true&enable_snippets=true&text=java&schedule=remote&from=cluster_schedule&showClusters=false";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int numberOfPages = 0;
        try {
            int page = 0;
            while (true) {
                Document doc = getDocument(searchString, page);
                if (doc == null) break;

                Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements == null) break;

                if (numberOfPages == 0) {
                    numberOfPages = Integer.parseInt(doc.getElementsByAttributeValue("data-qa", "pager-page").last().text()) - 1;
                }

                for (Element e : elements) {
                    String title = e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text();
                    String salary = e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text();
                    String city = e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text();
                    String companyName = e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text();
                    String siteName = "http://hh.ua/";
                    String url = e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href");

                    if (salary == null) salary = "";

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    vacancies.add(vacancy);

                }

                page++;
                if (page > numberOfPages) break;
            }
        } catch (Exception e) {

        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);

        return Jsoup
                .connect(url)
                .userAgent(userAgent)
                .referrer(referrer)
                .get();
    }



}
