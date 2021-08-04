package com.bldev.springparserrestapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class ParsingResult {
    private @Id @GeneratedValue Long id;

    private String parsingType;
    private String fileName;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParsingType() {
        return parsingType;
    }

    public void setParsingType(String parsingType) {
        this.parsingType = parsingType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
