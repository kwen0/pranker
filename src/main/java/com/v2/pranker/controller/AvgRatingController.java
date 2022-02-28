package com.v2.pranker.controller;

import com.v2.pranker.model.AvgRating;
import com.v2.pranker.model.AvgRatingJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AvgRatingController {
    @Autowired
    private AvgRatingJdbcRepository podRepo;

    @GetMapping("/avgratings")
    public ResponseEntity<List<AvgRating>> getAllAvgRatings() {
        try {
            List<AvgRating> avgRatings = podRepo.getAllAvgRatings();

            if (avgRatings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(avgRatings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/avgratings/{podcast_id}")
    public ResponseEntity<List<AvgRating>> getPodcastsRatingsById(@PathVariable("podcast_id") int podcast_id) {
        try {
            List<AvgRating> podcastRatingsById = podRepo.getAvgPodcastRatingsById(podcast_id);

            return new ResponseEntity<>(podcastRatingsById, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/avgrating/{podcast_id}")
    public ResponseEntity <Double> getAvgPodcastRating(@PathVariable("podcast_id") int podcast_id) {
        try {
            double avgPodcastRating = podRepo.getAvgPodcastRating(podcast_id);

            return new ResponseEntity<>(avgPodcastRating, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
