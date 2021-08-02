package com.bldev.springparserrestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestParsingController {
    @Autowired
    private Parsers parsers;

    private final ParserRepository repository;

    RestParsingController(ParserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/parsers")
    public List<Parser> getRestParsers(Model model) {
        return repository.findAll();
    }
}
