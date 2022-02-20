package com.v2.pranker.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PodRatingJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Pod> getAllPodcasts() {
        return jdbcTemplate.query("select * from POD", new BeanPropertyRowMapper<>(Pod.class));
    }

    public List<PodRating> getAllPodcastRatings() {
        return jdbcTemplate.query("select * from ratings", new BeanPropertyRowMapper<>(PodRating.class));
    }

}
