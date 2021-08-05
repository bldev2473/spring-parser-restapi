package com.bldev.springparserrestapi;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ParsingResultModelAssembler implements RepresentationModelAssembler<ParsingResult, EntityModel<ParsingResult>> {
    @Override
    public EntityModel<ParsingResult> toModel(ParsingResult parsingResult) {
        return EntityModel.of(parsingResult,
                linkTo(methodOn(RestParserController.class).getRestParsingResult(parsingResult.getId())).withSelfRel(),
                linkTo(methodOn(RestParserController.class).getRestParsingResults()).withRel("parsingResults"));
    }
}
