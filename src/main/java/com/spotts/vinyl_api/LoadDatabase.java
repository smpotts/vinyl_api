package com.spotts.vinyl_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(VinylRepository repository) {
        return args -> {
            log.info("Loading " + repository.save(new VinylRecord("The Sea", "Morcheeba")));
            log.info("Loading " + repository.save(new VinylRecord("The Time", "Dwight Yoakam")));
            log.info("Loading " + repository.save(new VinylRecord("When It Falls", "Zero7")));
            log.info("Loading " + repository.save(new VinylRecord("I Used To Know Her", "HER")));
        };
    }
}
