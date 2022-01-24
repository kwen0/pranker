package com.v2.pranker;

import com.v2.pranker.model.Pod;
import com.v2.pranker.model.PodJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PrankerApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(PrankerApplication.class);

	@Autowired
	private PodJdbcRepository podRepo;

	public static void main(String[] args) {
		SpringApplication.run(PrankerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Pod> podcasts = this.podRepo.getAllPodcasts();
		podcasts.forEach(podcast -> logger.info(podcast.toString()));
	}

}
