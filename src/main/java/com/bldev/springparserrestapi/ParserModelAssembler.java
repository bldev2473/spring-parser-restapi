package com.bldev.springparserrestapi;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ParserModelAssembler implements RepresentationModelAssembler<Parser, EntityModel<Parser>> {
    @Override
    public EntityModel<Parser> toModel(Parser parser) {
        return EntityModel.of(parser,
                linkTo(methodOn(RestParserController.class).getRestParser(parser.getId())).withSelfRel(),
                linkTo(methodOn(RestParserController.class).getRestParsersList()).withRel("parsers"));
    }
}
