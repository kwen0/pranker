package com.v2.pranker.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PodJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Pod> getAllPodcasts() {
        return jdbcTemplate.query("select * from POD", new BeanPropertyRowMapper<>(Pod.class));
    }

}
