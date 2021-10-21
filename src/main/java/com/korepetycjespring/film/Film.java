package com.korepetycjespring.film;

public class Film {
    private String title;
    private int durationInMins;

    public Film(String title, int durationInMins) {
        this.title = title;
        this.durationInMins = durationInMins;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDurationInMins() {
        return durationInMins;
    }
}

