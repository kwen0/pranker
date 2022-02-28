package com.v2.pranker.controller;

import com.v2.pranker.model.PodRating;
import com.v2.pranker.model.PodRatingJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PodRatingController {
    @Autowired
    private PodRatingJdbcRepository ratingsRepo;

    @GetMapping("/ratings")
    public ResponseEntity<List<PodRating>> getAllPodcastRatings() {
        try {
            List<PodRating> podcastRatings = ratingsRepo.getAllRatings();

            if (podcastRatings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(podcastRatings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ratings/{podcast_id}")
    public ResponseEntity<List<PodRating>> getPodcastsRatingsById(@PathVariable("podcast_id") int podcast_id) {
        try {
            List<PodRating> podcastRatingsById = ratingsRepo.getRatingsById(podcast_id);

            return new ResponseEntity<>(podcastRatingsById, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/avgrating/{podcast_id}")
    public ResponseEntity <Double> getAvgPodcastRating(@PathVariable("podcast_id") int podcast_id) {
        try {
            double avgPodcastRating = ratingsRepo.getAvgRating(podcast_id);

            return new ResponseEntity<>(avgPodcastRating, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
