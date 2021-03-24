package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o) {

        int rating;

        if (this.getName().equals(o.getName())){
            rating = 0;
        }
        else {
            rating = Float.compare(this.getDistance(), o.getDistance());
            if (rating != 0) return rating;
            rating = Integer.compare(this.getQuality(), o.getQuality());
            if (rating != 0) return rating;
        }




/*
        int r1 = 0;
        int r2 = 0;

        if (this.getDistance() > o.getDistance()) {
            r1 =+ 10;
        }
        else {
            r2 =+ 10;
        }

        if (this.getQuality() > o.getQuality()) {
            r1 =+ 50;
        }
        else {
            r2 =+ 50;
        }


        if (this.equals(o)) {
            rating = 0;
        }
        else {
            if (r1 > r2) {
                rating++;
            }
            else {
                rating--;
            }
        }
*/
        return rating;
    }

    public synchronized boolean equals(Beach obj) {

        if (this == obj) {
            return true;
        }
        else {
            return false;
        }

    }

    public static void main(String[] args) {

    }


}
