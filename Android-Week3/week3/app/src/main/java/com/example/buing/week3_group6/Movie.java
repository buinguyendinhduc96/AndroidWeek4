package com.example.buing.week3_group6;

import org.parceler.Parcel;

/**
 * Created by Hung on 30-Mar-18.
 */

@Parcel
public class Movie {
     String title;
     String vote_average;
     String backdrop_path;
     String overview;
     String release_date;

    public Movie() {

    }

    public Movie(String title, String vote_average,  String backdrop_path, String overview,String release_date) {
        this.title = title;
        this.vote_average = vote_average;
        this.backdrop_path = backdrop_path;
        this.overview = overview;
        this.release_date = release_date;


    }

    public String getTitle() {
        return title;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }
}
