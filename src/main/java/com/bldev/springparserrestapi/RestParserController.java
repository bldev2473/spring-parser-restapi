package com.bldev.springparserrestapi;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class RestParserController {
    private final ParserRepository parserRepository;
    private final ParsingResultRepository parsingResultRepository;
    private final ParserModelAssembler parserModelAssembler;
    private final ParsingResultModelAssembler parsingResultModelAssembler;
    private Parsers parsers;

    RestParserController(ParserRepository parserRepository, ParsingResultRepository parsingResultRepository, ParserModelAssembler parserModelAssembler, ParsingResultModelAssembler parsingResultModelAssembler, Parsers parsers) {
        this.parserRepository = parserRepository;
        this.parsingResultRepository = parsingResultRepository;
        this.parserModelAssembler = parserModelAssembler;
        this.parsingResultModelAssembler = parsingResultModelAssembler;
        this.parsers = parsers;
    }

    @RequestMapping("/parsers1")
    public Parsers getRestParsers() {
        return parsers;
    }

    /*
    @RequestMapping("/parsers2")
    public CollectionModel<EntityModel<Parser>> getRestParsersList() {
        List<EntityModel<Parser>> parsers = repository.findAll().stream()
                .map(parser -> EntityModel.of(parser,
                        linkTo(methodOn(RestParserController.class).getRestParser(parser.getId())).withSelfRel(),
                        linkTo(methodOn(RestParserController.class).getRestParsersList()).withRel("parsers")))
                .collect(Collectors.toList());

        return CollectionModel.of(parsers,
                linkTo(methodOn(RestParserController.class).getRestParsersList()).withSelfRel());
    }

    @RequestMapping("/parsers2/{id}")
    public EntityModel<Parser> getRestParser(@PathVariable Long id) {
        Parser parser = repository.findById(id).orElseThrow(() -> new ParserNotFoundException(id));
        return EntityModel.of(parser,
                linkTo(methodOn(RestParserController.class).getRestParser(id)).withSelfRel(),
                linkTo(methodOn(RestParserController.class).getRestParsersList()).withRel("parsers"));
    }
    */

    @RequestMapping("/parsers3/")
    public CollectionModel<EntityModel<Parser>> getRestParsersList() {
        List<EntityModel<Parser>> parsers = parserRepository.findAll().stream()
                .map(parserModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(parsers,
                linkTo(methodOn(RestParserController.class).getRestParsersList()).withSelfRel());
    }

    @RequestMapping("/parsers3/{id}")
    public EntityModel<Parser> getRestParser(@PathVariable Long id) {
        Parser parser = parserRepository.findById(id).orElseThrow(() -> new ParserNotFoundException(id));
        return parserModelAssembler.toModel(parser);
    }

    @RequestMapping("/parsingResults/")
    public CollectionModel<EntityModel<ParsingResult>> getRestParsingResults() {
        List<EntityModel<ParsingResult>> parsingResults = parsingResultRepository.findAll().stream()
                .map(parsingResultModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(parsingResults,
                linkTo(methodOn(RestParserController.class).getRestParsersList()).withSelfRel());
    }

    public EntityModel<ParsingResult> getRestParsingResult(Long id) {
        ParsingResult parsingResult = parsingResultRepository.findById(id).orElseThrow(() -> new ParserNotFoundException(id));
        return parsingResultModelAssembler.toModel(parsingResult);
    }
}
