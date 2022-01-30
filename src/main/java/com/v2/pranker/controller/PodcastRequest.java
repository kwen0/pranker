package com.v2.pranker.controller;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.springframework.web.bind.annotation.RequestBody;

public class PodcastRequest {
    private String episode_title;
    private String podcast_name;
    private double avg_rating;


    public String getEpisodeTitle() {
        return episode_title;
    }

    public void setEpisodeTitle(String episode_title) {
        this.episode_title = episode_title;
    }

    public String getPodcastName() {
        return podcast_name;
    }

    public void setPodcastName(String podcast_name) {
        this.podcast_name = podcast_name;
    }

    public double getAvgRating() {
        return avg_rating;
    }

    public void setAvgRating(double avg_rating) {
        this.avg_rating = avg_rating;
    }
}
