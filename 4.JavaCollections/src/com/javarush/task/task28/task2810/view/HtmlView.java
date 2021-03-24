package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HtmlView implements View {
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        updateFile(getUpdatedFileContent(vacancies));
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {

        try {
            Document doc = getDocument();

            Element elementTemplate = doc.getElementsByClass("template").first();
            Element template = (Element) elementTemplate.clone().removeClass("template")
                    .removeAttr("style");

            doc.select("tr[class=vacancy]").remove();

            for (Vacancy v : vacancies) {
                Element templateClone = template.clone();
                Element titleElement = templateClone
                        .select("a")
                        .first();
                titleElement.text(v.getTitle());
                titleElement.attr("href", v.getUrl());
                Element cityElement = templateClone
                        .select("td.city")
                        .first();
                cityElement.text(v.getCity());
                Element companyNameElement = templateClone
                        .select("td.companyName")
                        .first();
                companyNameElement.text(v.getCompanyName());
                Element salaryElement = templateClone
                        .select("td.salary")
                        .first();
                salaryElement.text(v.getSalary());

                doc.getElementsByClass("template")
                        .first()
                        .before(templateClone
                                .outerHtml());
            }
            return doc.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
    }

    protected Document getDocument() throws IOException {
        File in = new File(filePath);
        return Jsoup.parse(in, "UTF-8");
    }

    private void updateFile(String string) {
        try (FileOutputStream writer = new FileOutputStream(filePath)) {
            byte[] bytes = string.getBytes();
            writer.write(bytes);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    public String getFilePath() {
        return filePath;
    }
}
