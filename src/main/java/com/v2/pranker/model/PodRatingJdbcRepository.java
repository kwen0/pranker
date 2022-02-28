package com.v2.pranker.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class PodRatingJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PodRating> getAllPodcastRatings() {
        return jdbcTemplate.query("select * from ratings", new BeanPropertyRowMapper<>(PodRating.class));
    }

    public List<PodRating> getPodcastRatingsById(int id) {
        return jdbcTemplate.query(
                "select * from ratings where pod_id = ?",
                new Object[]{id},
                new int[]{Types.INTEGER},
                new BeanPropertyRowMapper<>(PodRating.class)
        );
    }

    public double getAvgPodcastRating(int id) {
        List<PodRating> ratings = jdbcTemplate.query(
                "select rating from ratings where pod_id = ?",
                new Object[]{id},
                new int[]{Types.INTEGER},
                new BeanPropertyRowMapper<>(PodRating.class)
        );
        double sum = 0;
        for (PodRating item : ratings) {
            sum += item.getRating();
        }
        return sum/ratings.size();
    }
}
