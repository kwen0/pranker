package com.v2.pranker.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.Iterator;
import java.util.List;

@Repository
public class AvgRatingJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<AvgRating> getAllAvgRatings() {
        return jdbcTemplate.query("select rating from ratings", new BeanPropertyRowMapper<>(AvgRating.class));
    }

    public List<AvgRating> getAvgPodcastRatingsById(int id) {
        return jdbcTemplate.query(
                "select rating from ratings where pod_id = ?",
                new Object[]{id},
                new int[]{Types.INTEGER},
                new BeanPropertyRowMapper<>(AvgRating.class)
        );
    }

    public double getAvgPodcastRating(int id) {
        List<AvgRating> ratings = jdbcTemplate.query(
                "select rating from ratings where pod_id = ?",
                new Object[]{id},
                new int[]{Types.INTEGER},
                new BeanPropertyRowMapper<>(AvgRating.class)
        );
        double sum = 0;
        for (AvgRating item : ratings) {
            sum += item.getRating();
        }
        return sum/ratings.size();
    }
}
