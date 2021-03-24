package com.javarush.task.task24.task2412.prognoz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prognoz {
    private List<String> sources = new ArrayList<>();
    private List<String> results = new ArrayList<>();
    private String fileSource = "source.txt";
    private String fileResults = "sresult.txt";

    public static void main(String[] args) {
        Prognoz prognoz = new Prognoz();
        int count = 0;
        try {
            prognoz.getSources(prognoz.fileSource, prognoz.sources);
            prognoz.getSources(prognoz.fileResults, prognoz.results);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < prognoz.results.size(); i++) {

            if (prognoz.results.get(i).equals(prognoz.sources.get(i))) {
                count += 3;
            }
            else {
                if (prognoz.isHostTeamWin(prognoz.results.get(i)) == prognoz.isHostTeamWin(prognoz.sources.get(i))) {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }

    public List<String> getSources(String fileName, List<String> sources) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        Pattern pattern = Pattern.compile("\\d+:\\d+|\\d+-\\d+");
        String line = null;
        while ((line = buffer.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                sources.add(matcher.group());
            }
        }
        buffer.close();
        return sources;
    }

    public int isHostTeamWin(String s) {
        String separator = null;
        if (s.contains(":")) {
            separator = ":";
        }
        else {
            separator = "-";
        }

        String[] goals = s.split(separator);
        int hostGoals = Integer.parseInt(goals[0]);
        int guestGoals = Integer.parseInt(goals[1]);
        if (hostGoals > guestGoals) {
            return 1;
        }
        else if (hostGoals < guestGoals) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
