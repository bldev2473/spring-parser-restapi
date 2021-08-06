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
    private String lineNumber;
    private String tableName;

    ParsingResult() {

    }

    ParsingResult(String fileName, String lineNumber, String tableName) {
        this.fileName = fileName;
        this.lineNumber = lineNumber;
        this.tableName = tableName;
    }

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

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
