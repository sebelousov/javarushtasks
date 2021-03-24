package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private List<Advertisement> videosForPlay = new ArrayList<>();

    private int timeSeconds;

    public static void main(String[] args) {
        AdvertisementManager manager = new AdvertisementManager(25 * 60);
        manager.videosForPlay.forEach(advertisement -> System.out.println(advertisement.getName()));
    }

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
        List<Advertisement> tempList = storage.list();
        tempList.sort((o1, o2) -> {
            int temp = (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
            if (temp != 0) return temp;
            else return o2.getDuration() - o1.getDuration();
        });
        selectVideos(tempList, timeSeconds);
    }

    public void processVideos() throws NoVideoAvailableException {
        int totalDuration = 0;
        for (Advertisement a : videosForPlay) {
            totalDuration += a.getDuration();
        }

        if (videosForPlay.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        long totalAmount = 0L;
        for (Advertisement a : videosForPlay) {
            totalAmount += a.getInitialAmount();
        }

        VideoSelectedEventDataRow eventDataRow = new VideoSelectedEventDataRow(videosForPlay, totalAmount, totalDuration);
        StatisticManager.getInstance().register(eventDataRow);

        for (Advertisement a : videosForPlay) {
            ConsoleHelper.writeMessage(a.getName() + " is displaying... " + a.getAmountPerOneDisplaying() + ", " + a.getAmountPerOneDisplaying() * 1000 / a.getDuration());
            a.revalidate();
        }
    }

    private void selectVideos(List<Advertisement> listVideos, int remainingTime) {
        if (!(remainingTime <= 0 || listVideos.isEmpty())) {
            List<Advertisement> listToDelete = new ArrayList<>(listVideos.size());
            for (Advertisement a : listVideos) {
                if (((remainingTime - a.getDuration()) >= 0) && a.getHits() > 0) {
                    videosForPlay.add(a);
                    remainingTime -= a.getDuration();
                    listToDelete.add(a);
                    selectVideos(listVideos, remainingTime);
                    break;
                }
            }
            listVideos.removeAll(listToDelete);
        }
    }
}
