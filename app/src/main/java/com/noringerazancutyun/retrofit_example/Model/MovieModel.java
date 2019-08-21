package com.noringerazancutyun.retrofit_example.Model;

import java.util.List;

public class MovieModel {

    private String title;
    private String image;
    private int releaseYear;
    private float rating;

    public float getRating() {
        return rating;
    }

    private List<String> genre;

    public int getReleaseYear() {
        return releaseYear;
    }

    public List<String> getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
