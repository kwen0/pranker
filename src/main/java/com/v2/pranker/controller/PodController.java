package com.v2.pranker.controller;

import com.v2.pranker.model.Pod;
import com.v2.pranker.model.PodJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8990")
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

}
