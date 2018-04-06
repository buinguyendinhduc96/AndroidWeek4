package com.example.buing.week3_group6;

/**
 * Created by buing on 16/03/2018.
 */

public class MovieObject {
    private String title;
    private String vote_average;
    private String poster_path;
    private String backdrop_path;
    private String video;
    private String overview;
    private String release_date;

    public MovieObject(){

    }

    public String getTittle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVoteAvarage() {
        return vote_average;
    }

    public void setVoteAvarage(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public void setPosterPath(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackDropPath() {
        return backdrop_path;
    }

    public void setBackDropPath(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(String release_date) {
        this.release_date = release_date;
    }

    public boolean isVideo(String video){
        if (video.equals("false")){
            return false;
        }
        else
            return true;
    }

    @Override
    public String toString() {
        return "MovieObject{" +
                "tittle='" + title + '\'' +
                ", voteAvarage=" + vote_average +
                ", posterPath='" + poster_path + '\'' +
                ", backDropPath='" + backdrop_path + '\'' +
                ", video=" + video +
                ", overview='" + overview + '\'' +
                ", releaseDate='" + release_date + '\'' +
                '}';
    }
}
