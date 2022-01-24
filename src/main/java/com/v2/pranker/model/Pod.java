package com.v2.pranker.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

public class Pod {
    private int id;
    private String episode_title;
    private String name;
    private double avg_rating;

    public Pod() {
    }

    public Pod(int id, String episode_title, String name, double avg_rating) {
        this.id = id;
        this.episode_title = episode_title;
        this.name = name;
        this.avg_rating = avg_rating;
    }

    public String getEpisodeTitle() {
        return episode_title;
    }

    public void setEpisodeTitle(String episode_title) {
        this.episode_title = episode_title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvgRating() {
        return avg_rating;
    }

    public void setAvgRating(double avg_rating) {
        this.avg_rating = avg_rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Podcast [id=%s, name=%s, episode=%s, rating=%s]", this.id, this.name, this.episode_title, this.avg_rating);
    }
}

