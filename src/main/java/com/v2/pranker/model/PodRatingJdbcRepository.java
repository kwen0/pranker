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

    public List<PodRating> getAllRatings() {
        return jdbcTemplate.query("select * from ratings", new BeanPropertyRowMapper<>(PodRating.class));
    }

    public List<PodRating> getRatingsById(int id) {
        return jdbcTemplate.query(
                "select * from ratings where pod_id = ?",
                new Object[]{id},
                new int[]{Types.INTEGER},
                new BeanPropertyRowMapper<>(PodRating.class)
        );
    }

    public double getAvgRating(int id) {
        List<PodRating> ratings = getRatingsById(id);
        double sum = 0;
        for (PodRating item : ratings) {
            sum += item.getRating();
        }
        double avgRating = sum/ratings.size();
        updateAvgRating(id, avgRating);
        return avgRating;
    }

    public void updateAvgRating(int id, double avgRating) {
        this.jdbcTemplate.update(
            "update pod set avg_rating = ? where id = ?",
                avgRating, id);
    }
}
