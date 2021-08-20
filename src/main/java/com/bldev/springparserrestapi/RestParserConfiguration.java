package com.bldev.springparserrestapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class RestParserConfiguration {
    private static final Logger log = LoggerFactory.getLogger(RestParserConfiguration.class);

    @Bean
    public Parsers parsers() {
        return new Parsers();
    }

    @Bean
    CommandLineRunner initParsers(Parsers parsers) {
        return args -> {
            parsers.addParser(new Parser("New Parser"));
        };
    }

    @Bean
    CommandLineRunner initDatabase(ParserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Parser("Default Parser")));
            log.info("Preloading " + repository.save(new Parser("Select Parser")));
        };
    }

    @Bean
    RestApiConsumer listener() {
        return new RestApiConsumer();
    }
}
