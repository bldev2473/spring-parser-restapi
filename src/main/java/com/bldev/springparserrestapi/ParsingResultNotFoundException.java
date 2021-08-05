package com.bldev.springparserrestapi;

public class ParsingResultNotFoundException extends RuntimeException {
    ParsingResultNotFoundException(Long id) {
        super("Could not find parsingResult " + id);
    }
}
