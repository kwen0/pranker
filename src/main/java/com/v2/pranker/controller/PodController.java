package com.v2.pranker.controller;

import com.v2.pranker.model.Pod;
import com.v2.pranker.model.PodJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin(origins = {"http://localhost:3000","https://pranker-frontend.herokuapp.com"})
@RestController
@RequestMapping("/api")
public class PodController {
    @Autowired
    private PodJdbcRepository podRepo;

    @GetMapping("/podcasts")
    public ResponseEntity<List<Pod>> getAllPodcasts() {
        try {
            List<Pod> podcasts = podRepo.getAllPodcasts();

            if (podcasts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(podcasts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/podcasts/{podcast_name}")
    public ResponseEntity<List<Pod>> getPodcastsByTitle(@PathVariable("podcast_name") String podcast_name) {
        try {
            List<Pod> podcasts = podRepo.getPodcastsByTitle(podcast_name);

            if (podcasts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(podcasts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/podcast/{podcast_id}")
    public ResponseEntity<Pod> getPodcastsById(@PathVariable("podcast_id") int podcast_id) {
        try {
            Pod podcast = podRepo.getPodcastById(podcast_id);

            if (podcast == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(podcast, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/podcasts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pod>> addPodcast(@RequestBody PodcastRequest pod_request) {
        try {
            System.out.println(pod_request.toString());
            boolean pod_added = podRepo.addPodcast(
                    new Random().nextInt(),
                    pod_request
            );


            if (pod_added) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
