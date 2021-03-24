package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT_TEST = "http://javarush.ru/testdata/big28data2.html";
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    private static final String userAgent = "Mozilla/5.0 (jsoup)";
    private static final int timeout = 5 * 1000;

    private String referrer = "https://moikrug.ru/vacancies";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int numberOfPages = 0;
        int page = 0;

        while (true) {
            try {
                Document doc = getDocument(searchString, page);
                if (doc == null) break;

                Elements elements = doc.select("div.job ");
                if (elements == null) break;

                if (numberOfPages == 0) {
                    numberOfPages = Integer.parseInt(doc.select("a.page").last().text()) - 1;
                }

                if (elements.size() > 1) {
                    for (Element e : elements) {
                        String title = e.select("div.title > a").text();
                        String salary = e.select("div.count").text().trim();
                        String city = e.select("span.location").text();
                        String companyName = e.select("div.company_name").text().trim();
                        String siteName = "http://moikrug.ru/";
                        String url = "https://moikrug.ru" + e.select("div.title > a").attr("href");

                        if (salary == null) salary = "";
                        if (city == null) city = "";

                        Vacancy vacancy = new Vacancy();
                        vacancy.setTitle(title);
                        vacancy.setSalary(salary);
                        vacancy.setCity(city);
                        vacancy.setCompanyName(companyName);
                        vacancy.setSiteName(siteName);
                        vacancy.setUrl(url);
                        vacancies.add(vacancy);
                    }
                }
                else {
                    break;
                }

                page++;
                if (page > numberOfPages) break;
            } catch (IOException e) {

            }
        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);
        return Jsoup
                .connect(url)
                .timeout(timeout)
                .userAgent(userAgent)
                .referrer(referrer)
                .get();
    }
}
