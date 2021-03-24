package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage instance;
    private final List<Advertisement> videos = new ArrayList<>();
    private int rate = 100; //количество копеек в 1 рубле
    private int numberSecondsInOneMinute = 60;

    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "#1", 1000 * rate, 100, 3 * numberSecondsInOneMinute));
        add(new Advertisement(someContent, "#2", 2000 * rate, 200, 5 * numberSecondsInOneMinute));
        add(new Advertisement(someContent, "#3", 3000 * rate, 500, 1 * numberSecondsInOneMinute));
        add(new Advertisement(someContent, "#4", 5000 * rate, 1000, 2 * numberSecondsInOneMinute));
        add(new Advertisement(someContent, "#5", 7000 * rate, 100, 3 * numberSecondsInOneMinute));
        add(new Advertisement(someContent, "#6", 9000 * rate, 200, 7 * numberSecondsInOneMinute));
        add(new Advertisement(someContent, "#7", 3000 * rate, 500, 1 * numberSecondsInOneMinute));
        add(new Advertisement(someContent, "#8", 1000 * rate, 1000, 2 * numberSecondsInOneMinute));

    }

    public static AdvertisementStorage getInstance() {
        if (instance == null) {
            instance = new AdvertisementStorage();
        }
        return instance;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
