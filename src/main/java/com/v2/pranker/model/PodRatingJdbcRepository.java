package com.v2.pranker.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Types;
import java.util.List;
import java.sql.SQLException;

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

    private String url = "jdbc:postgresql://localhost:5432/pranker";
    private String user = "main_pranker";
    private String password = "prankerpw";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void updateAvgRating(int id, double avgRating) {
        String SQL = "UPDATE pod " + "SET avg_rating = ? " + "WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setDouble(1, avgRating);
            pstmt.setInt(2, id);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
