package com.v2.pranker.model;

import com.v2.pranker.controller.PodcastRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class PodJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Pod> getAllPodcasts() {
        return jdbcTemplate.query("select * from POD", new BeanPropertyRowMapper<>(Pod.class));
    }

    public List<Pod> getPodcastsByTitle(String podcast_name) {
        return jdbcTemplate.query(
                "select * from POD where name = ?",
                new String[]{podcast_name},
                new int[]{Types.VARCHAR},
                new BeanPropertyRowMapper<>(Pod.class)
        );
    }

    public boolean addPodcast(int id, PodcastRequest pod_request) {
        return jdbcTemplate.update(
                "insert into pod values (?, ?, ?, ?)",
                id, pod_request.getEpisodeTitle(), pod_request.getPodcastName(), pod_request.getAvgRating()) == 1;
    }

}
