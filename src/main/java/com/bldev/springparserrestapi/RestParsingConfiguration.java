package com.bldev.springparserrestapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestParsingConfiguration {
    private static final Logger log = LoggerFactory.getLogger(RestParsingConfiguration.class);

    @Bean
    public Parsers parsers() {
        return new Parsers();
    }

    @Bean
    CommandLineRunner initDatabase(ParserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Parser("Default Parser")));
            log.info("Preloading " + repository.save(new Parser("Select Parser")));
        };
    }
}
