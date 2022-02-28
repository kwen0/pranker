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
    private PodRatingJdbcRepository podRepo;

    @GetMapping("/podcastratings")
    public ResponseEntity<List<PodRating>> getAllPodcastRatings() {
        try {
            List<PodRating> podcastRatings = podRepo.getAllPodcastRatings();

            if (podcastRatings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(podcastRatings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/podcastratings/{podcast_id}")
    public ResponseEntity<List<PodRating>> getPodcastsRatingsById(@PathVariable("podcast_id") int podcast_id) {
        try {
            List<PodRating> podcastRatingsById = podRepo.getPodcastRatingsById(podcast_id);

            return new ResponseEntity<>(podcastRatingsById, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/avgpodcastrating/{podcast_id}")
    public ResponseEntity <Double> getAvgPodcastRating(@PathVariable("podcast_id") int podcast_id) {
        try {
            double avgPodcastRating = podRepo.getAvgPodcastRating(podcast_id);

            return new ResponseEntity<>(avgPodcastRating, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
