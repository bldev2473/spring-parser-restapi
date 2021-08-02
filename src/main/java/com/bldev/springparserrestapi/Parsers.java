package com.bldev.springparserrestapi;

import java.util.ArrayList;
import java.util.List;

public class Parsers {
    private List<Parser> parsers = new ArrayList<>();

    public Parsers() {

    }

    public List<Parser> getParsers() {
        return parsers;
    }

    public void setParsers(List<Parser> parsers) {
        this.parsers = parsers;
    }
}
