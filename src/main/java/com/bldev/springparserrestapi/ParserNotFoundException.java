package com.bldev.springparserrestapi;

public class ParserNotFoundException extends RuntimeException {
    ParserNotFoundException(Long id) {
        super("Could not find parser " + id);
    }
}
