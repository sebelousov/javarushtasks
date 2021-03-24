package com.javarush.task.task24.task2412.prognoz;

public class GameResult {
    private String teamHome;
    private String teamGuest;
    private int goalsHome;
    private int goalsGuest;
    private int resultMatch;

    public GameResult(String teamHome, String teamGuest, int goalsHome, int goalsGuest) {
        this.teamHome = teamHome;
        this.teamGuest = teamGuest;
        this.goalsHome = goalsHome;
        this.goalsGuest = goalsGuest;
        this.resultMatch = goalsHome - goalsGuest;
    }

    public String getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(String teamHome) {
        this.teamHome = teamHome;
    }

    public String getTeamGuest() {
        return teamGuest;
    }

    public void setTeamGuest(String teamGuest) {
        this.teamGuest = teamGuest;
    }

    public int getGoalsHome() {
        return goalsHome;
    }

    public void setGoalsHome(int goalsHome) {
        this.goalsHome = goalsHome;
    }

    public int getGoalsGuest() {
        return goalsGuest;
    }

    public void setGoalsGuest(int goalsGuest) {
        this.goalsGuest = goalsGuest;
    }
}
