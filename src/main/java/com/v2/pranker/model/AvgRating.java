package com.v2.pranker.model;

public class AvgRating {
    private double rating;

    public AvgRating() {
    }

    public AvgRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("Average Ratings [rating=%s]", this.rating);
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

}

