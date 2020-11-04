package com.nazim.nntest.infrastructure.service.parser;

public interface FileInputParser {

    String getType();

    Integer parseStringToInteger(String textFileContent);

    default String[] getLines(String text){
        return text.split("\\r?\\n");
    }
}
