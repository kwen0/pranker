package com.v2.pranker.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

public class PodRating {
    private int id;
    private int user_id;
    private int pod_id;
    private double rating;
    private String comment;

    public PodRating() {
    }

    public PodRating(int id, int user_id, int pod_id, double rating, String comment) {
        this.id = id;
        this.user_id = user_id;
        this.pod_id = pod_id;
        this.rating = rating;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return String.format("Podcast Rating [id=%s, user_id=%s, pod_id=%s, rating=%s, comment=%s]", this.id, this.user_id, this.pod_id, this.rating, this.comment);
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getPodId() {
        return pod_id;
    }

    public void setPodId(int pod_id) {
        this.pod_id = pod_id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

